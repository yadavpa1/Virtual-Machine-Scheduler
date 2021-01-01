package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.List;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Datacenter;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.VCenter;

public interface DatacenterService {
	
	public List<Datacenter> findAll();
	
	public Datacenter findById(int ids);
	
	public void save(Datacenter datacenter);
	
	public void deleteById(int id);
	
	public VCenter findVCenterInfo();
	
	public long count();
}
