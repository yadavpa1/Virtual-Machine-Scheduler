package com.vmware.vmscheduler.vmschedulerspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.VirtualMachine;

public interface VirtualMachineRepository extends JpaRepository<VirtualMachine, Integer> {
	
	@Query("select v from VirtualMachine v where v.hostId=:hostId")
	List<VirtualMachine> findAllByHostId(@Param("hostId") int hostId);
	
	@Query("select v from VirtualMachine v inner join Host h on h.hostId = v.hostId "
			+ "inner join Cluster c on c.clusterId = h.clusterId "
			+ "where c.clusterId=:clusterId")
	List<VirtualMachine> findAllByClusterId(@Param("clusterId") int clusterId);
}
