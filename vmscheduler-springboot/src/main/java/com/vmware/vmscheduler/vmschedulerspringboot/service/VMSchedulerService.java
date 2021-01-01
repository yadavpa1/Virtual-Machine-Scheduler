package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Host;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.VirtualMachine;

@Service
public class VMSchedulerService {
	private HostService hostService;
	private VirtualMachineService vmService;
	
	@Autowired
	public VMSchedulerService(HostService hostService,VirtualMachineService vmService) {
		this.hostService = hostService;
		this.vmService = vmService;
				
	}
	
	/*Inputs: 
	 *      - VM set V , 
	 *      - PM set P in the data center, and
	 *      - initial VM/PM mapping M. 
	 *Outputs:
	 *		- updated VM/PM mapping M.
	 */	
	public HashMap<Integer,Integer> offlineServerLoad(int failedMigLimit, List<VirtualMachine> vms, List<Host> hosts, HashMap<Integer,Integer> hmap) {
		int failedMig = 0;
		double[][] hostOccupiedMag = new double[hosts.size()][2];
		for(int i = 0; i<hosts.size(); i++) {
			Host h = hosts.get(i);
			hostOccupiedMag[i][0] = h.getHostId();
			hostOccupiedMag[i][1] = calOccupiedMagnitude(h.getAllotedCpuCount(),h.getAllotedMemorySizeMiB());
		}
		sortbyColumnDesc(hostOccupiedMag); //descending order of occupancy
		for(int i = hostOccupiedMag.length-1; i>=0; i--) { //starting from least loaded
			Host h = hostService.findById((int)hostOccupiedMag[i][0]);  //PM i
			HashMap<Integer,Integer> backupMap = new HashMap<Integer, Integer>();
			backupMap.putAll(hmap); // M backup
			double[][] backedUpHostOccupiedMag = hostOccupiedMag.clone(); // P backup
			
			int noOfVmsOnHostI = vmService.findAllById(h.getHostId()).size();
			double[][] vmOccupiedMag = new double[noOfVmsOnHostI][2];
			int p = 0;
			for(int l = 0; l<vms.size(); l++) { // of all vms
				if(vms.get(l).getHostId() == h.getHostId() ) { //ones on PM i
					VirtualMachine vm = vms.get(l);
					vmOccupiedMag[p][0] = vm.getVmId();
					vmOccupiedMag[p][1] = calOccupiedMagnitude(vm.getCpuCount(),vm.getMemorySizeMiB());
					p++;
				}
			}
			sortbyColumnDesc(vmOccupiedMag); //descending order
			
			int noOfVmsLeftToMigrate = noOfVmsOnHostI;
			for(int j=0; j< vmOccupiedMag.length; j++) { //vms on PM i
				for(int k=0; k<= i; k++) { //hosts starting from most loaded
					Host host = hostService.findById((int)hostOccupiedMag[k][0]); // PM k
					VirtualMachine vm = vmService.findById((int)vmOccupiedMag[j][0]); //V[i][j]
					if(doesVMFitInHost(host,vm) == true) {
						hmap.replace(vm.getVmId(), host.getHostId());
						int newHostCpuCount = host.getAllotedCpuCount() + vm.getCpuCount();
						int newHostMemorySize = host.getAllotedMemorySizeMiB() + vm.getMemorySizeMiB();
						hostOccupiedMag[k][1] = calOccupiedMagnitude(newHostCpuCount,newHostMemorySize);
						sortbyColumnDesc(hostOccupiedMag); //descending order of occupancy
						noOfVmsLeftToMigrate -= 1;
					}
				}
			}
			if(noOfVmsLeftToMigrate == 0) {
				hostOccupiedMag = backedUpHostOccupiedMag.clone();
				hmap.putAll(backupMap);
				failedMig += 1;
			}
			if(failedMig >= failedMigLimit) {
				System.out.println("No. of Failed Migrations crossed the set limit.");
				return null;
			}
			
		}
		return hmap;
	}
	
	private double calOccupiedMagnitude(int cpuCount, int memorySizeMiB ) {
		double result = Math.sqrt((cpuCount)*(cpuCount) +(memorySizeMiB)*(memorySizeMiB));
	    System.out.println(result); 
		return result;
	}
	
	private void sortbyColumnDesc(double arr[][]) {
		Arrays.sort(arr, new Comparator<double[]>() {             
			public int compare(final double[] entry1, final double[] entry2) { 
				if (entry1[1] < entry2[1]) 
					return 1; 
		        else 
		        	return -1; 
		    } 
		});  
    } 
	
	private boolean doesVMFitInHost(Host host, VirtualMachine vm) {
		int vmCpuCount = vm.getCpuCount();
		int vmMemorySize = vm.getMemorySizeMiB();
		int hostRemainingCpuCount = host.getCpuCount()-host.getAllotedCpuCount();
		int hostRemainingMemorySize = host.getMemorySizeMiB()-host.getAllotedMemorySizeMiB();
		if((vmCpuCount <= hostRemainingCpuCount) && (vmMemorySize <= hostRemainingMemorySize)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int onlineServerLoad(VirtualMachine vm, List<Host> hosts) {
		/*Inputs: 
		 *      - VM v , 
		 *      - PM set P in the data center, and
		 *      - initial VM/PM mapping M. 
		 *Outputs:
		 *		- updated VM/PM mapping M
		 */
		double[][] hostOccupiedMag = new double[hosts.size()][2];
		for(int i = 0; i<hosts.size(); i++) {
			Host h = hosts.get(i);
			hostOccupiedMag[i][0] = h.getHostId();
			hostOccupiedMag[i][1] = calOccupiedMagnitude(h.getAllotedCpuCount(),h.getAllotedMemorySizeMiB());
		}
		sortbyColumnDesc(hostOccupiedMag); //descending order of occupancy
		
		for(int i=0;i<hosts.size();i++) {
			Host host = hostService.findById((int)hostOccupiedMag[i][0]);  //PM i
			if(doesVMFitInHost(host,vm) == true) { //place vm on host
				//hmap.replace(vm.getVmId(), host.getHostId());
				//int newHostCpuCount = host.getAllotedCpuCount() + vm.getCpuCount();
				//int newHostMemorySize = host.getAllotedMemorySizeMiB() + vm.getMemorySizeMiB();
				
				//hostOccupiedMag[i][1] = calOccupiedMagnitude(newHostCpuCount,newHostMemorySize);
				//sortbyColumnDesc(hostOccupiedMag); //descending order of occupancy
				return host.getHostId();
			}
		}
		return -1; //reject request for v
	}
	
}
