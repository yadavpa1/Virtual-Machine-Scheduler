package com.vmware.vmscheduler.vmschedulerspringboot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Cluster;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Datacenter;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Host;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.VCenter;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.VirtualMachine;
import com.vmware.vmscheduler.vmschedulerspringboot.exception.RecordNotFoundException;
import com.vmware.vmscheduler.vmschedulerspringboot.service.ClusterService;
import com.vmware.vmscheduler.vmschedulerspringboot.service.DatacenterService;
import com.vmware.vmscheduler.vmschedulerspringboot.service.HostService;
import com.vmware.vmscheduler.vmschedulerspringboot.service.VMSchedulerService;
import com.vmware.vmscheduler.vmschedulerspringboot.service.VirtualMachineService;

@RestController
@RequestMapping("/api/vms")
public class VMSRestController {
	
	private DatacenterService datacenterService;
	private ClusterService clusterService;
	private HostService hostService;
	private VirtualMachineService vmService;
	private VMSchedulerService schedulerService;
	
	@Autowired
	public VMSRestController(DatacenterService datacenterService,
			ClusterService clusterService,
			HostService hostService,
			VirtualMachineService vmService,
			VMSchedulerService schedulerService) {
		this.datacenterService = datacenterService;
		this.clusterService = clusterService;
		this.hostService = hostService;
		this.vmService = vmService;
		this.schedulerService = schedulerService;
	}
	
	/*************************************** DATACENTER *******************************************/
	
	/* GET ALL DATACENTERS IN THE VCENTER INVENTORY */
	@GetMapping("/datacenters")
	public List<Datacenter> findAllDatacenters(){
		return datacenterService.findAll();
	}
	
	/* GET A SINGLE DATACENTER IN THE VCENTER INVENTORY */
	@GetMapping("/datacenters/{datacenterId}")
	public Datacenter getDatacenter(@PathVariable int datacenterId) {
		Datacenter datacenter = datacenterService.findById(datacenterId);
		if(datacenter == null) {
			throw new RecordNotFoundException("Datacenter id not found - "+datacenterId);
		}
		return datacenter;
	}
	
	/* INSERT A DATACENTER IN THE VCENTER INVENTORY */
	@PostMapping("/datacenters")
	public Datacenter addDatacenter(@RequestBody Datacenter datacenter) {
		datacenter.setDatacenterId(0);
		datacenterService.save(datacenter);
		return datacenter;
	}
	
	/* UPDATE A DATACENTER IN THE VCENTER INVENTORY */
	@PutMapping("/datacenters")
	public Datacenter updateDatacenter(@RequestBody Datacenter datacenter) {
		datacenterService.save(datacenter);
		return datacenter;
	}
	
	/* DELETE A DATACENTER IN THE VCENTER INVENTORY */
	@DeleteMapping("/datacenters/{datacenterId}")
	public String deleteDatacenter(@PathVariable int datacenterId) {
		Datacenter datacenter = datacenterService.findById(datacenterId);
		System.out.println(datacenter);
		if(datacenter == null) {
			throw new RecordNotFoundException("Datacenter id not found - "+datacenterId);
		}
		datacenterService.deleteById(datacenterId);
		return "Deleted datacenter id - "+ datacenterId;
	}
	
	/**************************************** CLUSTER ********************************************/
	
	/* GET ALL CLUSTERS IN THE VCENTER INVENTORY */
	@GetMapping("/clusters")
	public List<Cluster> findAllClusters(){
		return clusterService.findAll();
	}
	
	/* GET A SINGLE CLUSTER IN THE VCENTER INVENTORY */
	@GetMapping("/clusters/{clusterId}")
	public Cluster getCluster(@PathVariable int clusterId) {
		Cluster cluster = clusterService.findById(clusterId);
		if(cluster == null) {
			throw new RecordNotFoundException("Cluster id not found - "+clusterId);
		}
		return cluster;
	}
	
	/* INSERT A CLUSTER IN THE VCENTER INVENTORY */
	@PostMapping("/clusters")
	public Cluster addCluster(@RequestBody Cluster cluster) {
		cluster.setClusterId(0);
		clusterService.save(cluster);
		return cluster;
	}
	
	/* UPDATE A CLUSTER IN THE VCENTER INVENTORY */
	@PutMapping("/clusters")
	public Cluster updateCluster(@RequestBody Cluster cluster) {
		clusterService.save(cluster);
		return cluster;
	}
	
	/* DELETE A CLUSTER IN THE VCENTER INVENTORY */
	@DeleteMapping("/clusters/{clusterId}")
	public String deleteCluster(@PathVariable int clusterId) {
		Cluster cluster = clusterService.findById(clusterId);
		if(cluster == null) {
			throw new RecordNotFoundException("Cluster id not found - "+ clusterId);
		}
		clusterService.deleteById(clusterId);
		return "Deleted cluster id - "+ clusterId;
	}
	
	/******************************************* HOST ******************************************/
	
	/* GET ALL HOSTS IN THE VCENTER INVENTORY */
	@GetMapping("/hosts")
	public List<Host> findAllHosts(){
		return hostService.findAll();
	}
	
	/* GET A SINGLE HOST IN THE VCENTER INVENTORY */
	@GetMapping("/hosts/{hostId}")
	public Host getHost(@PathVariable int hostId) {
		Host host = hostService.findById(hostId);
		if(host == null) {
			throw new RecordNotFoundException("Host id not found - "+ hostId);
		}
		return host;
	}
	
	/* INSERT A HOST IN THE VCENTER INVENTORY */
	@PostMapping("/hosts")
	public Host addHost(@RequestBody Host host) {
		host.setHostId(0);
		hostService.save(host);
		return host;
	}
	
	/* UPDATE A HOST IN THE VCENTER INVENTORY */
	@PutMapping("/hosts")
	public Host updateHost(@RequestBody Host host) {
		hostService.save(host);
		return host;
	}
	
	/* DELETE A HOST IN THE VCENTER INVENTORY */
	@DeleteMapping("/hosts/{hostId}")
	public String deleteHost(@PathVariable int hostId) {
		Host host = hostService.findById(hostId);
		if(host == null) {
			throw new RecordNotFoundException("Host id not found - "+ hostId);
		}
		hostService.deleteById(hostId);
		return "Deleted host id - "+ hostId;
	}
	
/***************************************** VIRTUAL MACHINE ****************************************/
	
	/* GET ALL VM's IN THE VCENTER INVENTORY */
	@GetMapping("/virtualmachines")
	public List<VirtualMachine> findAllVms(){
		return vmService.findAll();
	}
	
	/* GET A SINGLE VM IN THE VCENTER INVENTORY */
	@GetMapping("/virtualmachines/{vmId}")
	public VirtualMachine getVM(@PathVariable int vmId) {
		VirtualMachine vm = vmService.findById(vmId);
		if(vm == null) {
			throw new RecordNotFoundException("VM id not found - "+ vmId);
		}
		return vm;
	}
	
	/* INSERT A VM AT CLUSTER LEVEL IN THE VCENTER INVENTORY */
	@PostMapping("/virtualmachines/clusterlevel/{clusterId}")
	public VirtualMachine addVMAtClusterLevel(@RequestBody VirtualMachine vm, @PathVariable int clusterId) {
		vm.setVmId(0);
		HashMap<Integer, Integer> vmHostMap = vmService.getVmHostMapping(clusterId);
		vmHostMap = schedulerService.offlineServerLoad(10, vmService.findAllByClusterId(clusterId), hostService.findAllById(clusterId), vmHostMap);
		vmService.updateHostIds(vmHostMap);
		int isAdded = schedulerService.onlineServerLoad(vm, hostService.findAllById(clusterId));
		if(isAdded == -1) {
			throw new RuntimeException("VM insertion request failed due to insufficient resource. -"+ vm.getVmId());
		}
		else {
			vm.setHostId(isAdded);
		}
		vmService.save(vm);
		return vm;
	}
	
	/* INSERT A VM AT HOST LEVEL IN THE VCENTER INVENTORY */
	@PostMapping("/virtualmachines/hostlevel")
	public VirtualMachine addVMAtHostLevel(@RequestBody VirtualMachine vm) {
		Host host = hostService.findById(vm.getHostId());
		if((host.getAllotedCpuCount()+ vm.getCpuCount() <= host.getCpuCount()) && (host.getAllotedMemorySizeMiB())+ vm.getMemorySizeMiB() <= host.getMemorySizeMiB()) {
			vm.setVmId(0);
			vmService.save(vm);
		}
		else {
			throw new RuntimeException("VM insertion request failed due to insufficient resource. - "+ vm.getVmId());
		}
		return vm;
	}
	
	/* UPDATE A VM IN THE VCENTER INVENTORY */
	@PutMapping("/virtualmachines")
	public VirtualMachine updateVM(@RequestBody VirtualMachine vm) {
		vmService.save(vm);
		return vm;
	}
	
	/* DELETE A VM IN THE VCENTER INVENTORY */
	@DeleteMapping("/virtualmachines/{vmId}")
	public String deleteVM(@PathVariable int vmId) {
		VirtualMachine vm = vmService.findById(vmId);
		if(vm == null) {
			throw new RecordNotFoundException("VM id not found - "+ vmId);
		}
		vmService.deleteById(vmId);
		return "Deleted VM id - "+ vmId;
	}
	
	/***************************************** VCENTER *******************************************/
	
	/* GET VC INFO AND THE VCENTER INVENTORY */
	@GetMapping("/vc")
	public VCenter getVCInfoAndInventory() { 
		VCenter vcenter = datacenterService.findVCenterInfo();
		List<Datacenter> datacenters = datacenterService.findAll();
		for(Datacenter d: datacenters) {
			List<Cluster> clusters = clusterService.findAllById(d.getDatacenterId());
			for(Cluster c: clusters) {
				List<Host> hosts = hostService.findAllById(c.getClusterId());
				for(Host h: hosts) {
					h.setVmList(vmService.findAllById(h.getHostId()));	
				}
				c.setHostList(hosts);
			}
			d.setClusterList(clusters);
		}
		vcenter.setInventory(datacenters);
		return vcenter;
	}

}
