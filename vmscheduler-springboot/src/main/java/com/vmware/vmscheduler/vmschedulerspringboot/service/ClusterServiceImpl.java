package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.AllotedResource;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Cluster;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Resource;
import com.vmware.vmscheduler.vmschedulerspringboot.exception.RecordNotFoundException;
import com.vmware.vmscheduler.vmschedulerspringboot.repository.ClusterRepository;

@Service
public class ClusterServiceImpl implements ClusterService {
	
	private ClusterRepository clusterRepo;
	
	@Autowired
	public ClusterServiceImpl(ClusterRepository clusterRepo) {
		this.clusterRepo = clusterRepo;
	}
	
	@Override
	public List<Cluster> findAll() {
		List<Cluster> clusters = clusterRepo.findAll();
		for(Cluster cluster: clusters) {
			cluster.setNoOfHosts(clusterRepo.findNoOfHosts(cluster.getClusterId()));
			cluster.setNoOfVms(clusterRepo.findNoOfVms(cluster.getClusterId()));
			Resource resource = clusterRepo.findResource(cluster.getClusterId());
			cluster.setResource(resource);
			AllotedResource allotedResource = clusterRepo.findAllotedResource(cluster.getClusterId());		
			cluster.setAllotedResource(allotedResource);
		}
		return clusters;
	}
	
	@Override
	public List<Cluster> findAllById(int id) {
		List<Cluster> clusters = clusterRepo.findAllByDatacenterId(id);
		for(Cluster c: clusters) {
			c.setNoOfHosts(clusterRepo.findNoOfHosts(c.getClusterId()));
			c.setNoOfVms(clusterRepo.findNoOfVms(c.getClusterId()));
			Resource resource = clusterRepo.findResource(c.getClusterId());
			AllotedResource allotedResource = clusterRepo.findAllotedResource(c.getClusterId());
			c.setResource(resource);
			c.setAllotedResource(allotedResource);
		}
		return clusters;
	}

	@Override
	public Cluster findById(int id) {
		Optional<Cluster> result = clusterRepo.findById(id);
		Cluster cluster = null;
		if(result.isPresent()) {
			cluster = result.get();
		}else {
			throw new RecordNotFoundException("Did not find cluster id - "+ id);
		}
		cluster.setNoOfHosts(clusterRepo.findNoOfHosts(id));
		cluster.setNoOfVms(clusterRepo.findNoOfVms(id));
		Resource resource = clusterRepo.findResource(id);
		AllotedResource allotedResource = clusterRepo.findAllotedResource(id);
		cluster.setResource(resource);
		cluster.setAllotedResource(allotedResource);
		return cluster;
	}

	@Override
	public void save(Cluster cluster) {
		clusterRepo.save(cluster);
	}

	@Override
	public void deleteById(int id) {
		clusterRepo.deleteById(id);
	}
	
	@Override
	public long count() {
		return clusterRepo.count();
	}

}
