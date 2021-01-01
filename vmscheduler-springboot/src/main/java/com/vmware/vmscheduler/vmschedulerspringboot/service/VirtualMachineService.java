package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.HashMap;
import java.util.List;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.VirtualMachine;;

public interface VirtualMachineService {
	
	public List<VirtualMachine> findAll();
	
	public List<VirtualMachine> findAllById(int id);
	
	public List<VirtualMachine> findAllByClusterId(int id);
	
	public VirtualMachine findById(int id);
	
	public void save(VirtualMachine vm);
	
	public void deleteById(int id);
	
	public long count();
	
	public HashMap<Integer, Integer> getVmHostMapping(int id);
	
	public void updateHostIds(HashMap<Integer,Integer> vmHostMap);
}
