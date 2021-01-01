package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.VirtualMachine;
import com.vmware.vmscheduler.vmschedulerspringboot.exception.RecordNotFoundException;
import com.vmware.vmscheduler.vmschedulerspringboot.repository.VirtualMachineRepository;

@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {
	
	private VirtualMachineRepository vmRepo;
	
	@Autowired
	public VirtualMachineServiceImpl(VirtualMachineRepository vmRepo) {
		this.vmRepo = vmRepo;
	}
	
	@Override
	public List<VirtualMachine> findAll() {
		return vmRepo.findAll();
	}
	
	@Override
	public List<VirtualMachine> findAllById(int id) {
		return vmRepo.findAllByHostId(id);
	}

	@Override
	public VirtualMachine findById(int id) {
		Optional<VirtualMachine> result = vmRepo.findById(id);
		VirtualMachine vm = null;
		if(result.isPresent()) {
			vm = result.get();
		}else {
			throw new RecordNotFoundException("Did not find vm id - "+id);
		}
		return vm;
	}
	
	@Override
	public List<VirtualMachine> findAllByClusterId(int id){
		return vmRepo.findAllByClusterId(id);
	}

	@Override
	public void save(VirtualMachine vm) {
		vmRepo.save(vm);
	}

	@Override
	public void deleteById(int id) {
		vmRepo.deleteById(id);
	}
	
	@Override
	public long count() {
		return vmRepo.count();
	}

	@Override
	public HashMap<Integer, Integer> getVmHostMapping(int id) {
		HashMap<Integer, Integer> vmHostMap = new HashMap<Integer, Integer>();
		List<VirtualMachine> vmList = vmRepo.findAllByClusterId(id);
		for(VirtualMachine vm: vmList) {
			vmHostMap.put(vm.getVmId(), vm.getHostId());
		}
		return vmHostMap;
	}
	
	@Override
	public void updateHostIds(HashMap<Integer,Integer> vmHostMap) {
		for(Map.Entry<Integer, Integer> entry: vmHostMap.entrySet()) {
			VirtualMachine vm = vmRepo.findById(entry.getKey().intValue()).get();
			int newHostId = entry.getValue().intValue();
			if(vm.getHostId() != newHostId) {
				vm.setHostId(newHostId);
				vmRepo.save(vm);
			}
		}
	}

}
