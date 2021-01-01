package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.List;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Host;

public interface HostService {
	
	public List<Host> findAll();
	
	public List<Host> findAllById(int id);
	
	public Host findById(int id);
	
	public void save(Host host);
	
	public void deleteById(int id);
	
	public long count();
}
