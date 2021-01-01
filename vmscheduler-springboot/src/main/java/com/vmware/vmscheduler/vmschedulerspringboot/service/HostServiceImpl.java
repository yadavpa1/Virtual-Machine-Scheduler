package com.vmware.vmscheduler.vmschedulerspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Host;
import com.vmware.vmscheduler.vmschedulerspringboot.exception.RecordNotFoundException;
import com.vmware.vmscheduler.vmschedulerspringboot.repository.HostRepository;

@Service
public class HostServiceImpl implements HostService {
	
	private HostRepository hostRepo;
	
	@Autowired
	public HostServiceImpl(HostRepository hostRepo) {
		this.hostRepo = hostRepo;
	}
	
	@Override
	public List<Host> findAll() {
		return hostRepo.findAll();
	}
	
	@Override
	public List<Host> findAllById(int id) {
		return hostRepo.findAllByClusterId(id);
	}

	@Override
	public Host findById(int id) {
		Optional<Host> result = hostRepo.findById(id);
		Host host = null;
		if(result.isPresent()) {
			host = result.get();
		}else {
			throw new RecordNotFoundException("Did not find host id - "+id);
		}
		return host;
	}

	@Override
	public void save(Host host) {
		hostRepo.save(host);
	}

	@Override
	public void deleteById(int id) {
		hostRepo.deleteById(id);
	}
	
	@Override
	public long count() {
		return hostRepo.count();
	}

}
