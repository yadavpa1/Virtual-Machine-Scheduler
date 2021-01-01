package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.List;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Cluster;

public interface ClusterService {
	public List<Cluster> findAll();
	
	public List<Cluster> findAllById(int id);
	
	public Cluster findById(int id);
	
	public void save(Cluster cluster);
	
	public void deleteById(int id);
	
	public long count();
}
