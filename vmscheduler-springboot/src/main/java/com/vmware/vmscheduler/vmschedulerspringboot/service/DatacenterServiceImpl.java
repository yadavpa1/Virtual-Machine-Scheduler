package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Datacenter;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Resource;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.VCenter;
import com.vmware.vmscheduler.vmschedulerspringboot.exception.RecordNotFoundException;
import com.vmware.vmscheduler.vmschedulerspringboot.repository.DatacenterRepository;

@Service
public class DatacenterServiceImpl implements DatacenterService {
	
	private DatacenterRepository datacenterRepo;
	
	@Autowired
	public DatacenterServiceImpl(DatacenterRepository datacenterRepo) {
		this.datacenterRepo = datacenterRepo;
	}
	
	@Override
	public List<Datacenter> findAll() {
		List<Datacenter> datacenters = datacenterRepo.findAll();
		for(Datacenter datacenter: datacenters) {
			datacenter.setNoOfHosts(datacenterRepo.findNoOfHosts(datacenter.getDatacenterId()));
			datacenter.setNoOfClusters(datacenterRepo.findNoOfClusters(datacenter.getDatacenterId()));
			datacenter.setNoOfVms(datacenterRepo.findNoOfVms(datacenter.getDatacenterId()));
			datacenter.setResource(datacenterRepo.findResource(datacenter.getDatacenterId()));
		}
		return datacenters;
	}

	@Override
	public Datacenter findById(int id) {
		Optional<Datacenter> result = datacenterRepo.findById(id);
		Datacenter datacenter = null;
		if(result.isPresent()) {
			datacenter = result.get();
		}else {
			throw new RecordNotFoundException("Did not find datacenter id - "+id);
		}
		datacenter.setNoOfHosts(datacenterRepo.findNoOfHosts(id));
		datacenter.setNoOfClusters(datacenterRepo.findNoOfClusters(id));
		datacenter.setNoOfVms(datacenterRepo.findNoOfVms(id));
		datacenter.setResource(datacenterRepo.findResource(id));
		return datacenter;
	}

	@Override
	public void save(Datacenter datacenter) {
		datacenter.setNoOfHosts(datacenterRepo.findNoOfHosts(0));
		datacenter.setNoOfClusters(datacenterRepo.findNoOfClusters(0));
		datacenter.setNoOfVms(datacenterRepo.findNoOfVms(0));
		datacenter.setResource(new Resource(0L,0L));
		datacenterRepo.save(datacenter);
	}

	@Override
	public void deleteById(int id) {
		datacenterRepo.deleteById(id);
	}
	
	@Override
	public VCenter findVCenterInfo() {
		VCenter vc = new VCenter();
		int noOfDatacenters = 0;
		int noOfHosts = 0;
		int noOfClusters = 0;
		int noOfVms = 0;
		Long cpuCount = 0L;
		Long memorySizeMiB = 0L;
		Resource resource = null;
		vc.setVcenterName("VCENTER-01A");
		List<Datacenter> datacenters = datacenterRepo.findAll();
		for(Datacenter d: datacenters) {
			noOfDatacenters += 1;
			noOfHosts += datacenterRepo.findNoOfHosts(d.getDatacenterId());
			noOfClusters += datacenterRepo.findNoOfClusters(d.getDatacenterId());
			noOfVms += datacenterRepo.findNoOfVms(d.getDatacenterId());
			Resource res = datacenterRepo.findResource(d.getDatacenterId());
			System.out.println(res);
			if(res.getCpuCount()!=null) {
				cpuCount = Long.sum(cpuCount, res.getCpuCount());
				memorySizeMiB = Long.sum(memorySizeMiB, res.getMemorySizeMiB());
			}
		}
		vc.setNoOfDatacenters(noOfDatacenters);
		vc.setNoOfHosts(noOfHosts);
		vc.setNoOfClusters(noOfClusters);
		vc.setNoOfVms(noOfVms);
		if(cpuCount != 0L && memorySizeMiB != 0L) {
			resource = new Resource(cpuCount,memorySizeMiB);
			vc.setResource(resource);
		}else {
			vc.setResource(new Resource(0L,0L));
		}
		return vc;
	}
	
	@Override
	public long count() {
		return datacenterRepo.count();
	}

}
