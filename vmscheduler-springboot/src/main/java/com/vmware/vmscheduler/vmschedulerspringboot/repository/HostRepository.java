package com.vmware.vmscheduler.vmschedulerspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Host;

public interface HostRepository extends JpaRepository<Host, Integer	> {
	
	@Query("select h from Host h where h.clusterId=:clusterId")
	List<Host> findAllByClusterId(@Param("clusterId") int clusterId);
}
