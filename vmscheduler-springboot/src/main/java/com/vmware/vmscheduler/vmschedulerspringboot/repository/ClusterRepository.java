package com.vmware.vmscheduler.vmschedulerspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.AllotedResource;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Cluster;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Resource;

public interface ClusterRepository extends JpaRepository<Cluster, Integer> {
	
	@Query("select COUNT(*) from Host h where h.clusterId=:clusterId")
	int findNoOfHosts(@Param("clusterId") int clusterId);
	
	@Query("select COUNT(v.vmId) from Cluster c inner join Host h on c.clusterId = h.clusterId "
			+ "inner join VirtualMachine v on h.hostId = v.hostId "
			+ "where c.clusterId=:clusterId")
	int findNoOfVms(@Param("clusterId") int clusterId);
	
	@Query("select new com.vmware.vmscheduler.vmschedulerspringboot.entity.Resource(SUM(h.cpuCount),SUM(h.memorySizeMiB)) "
			+ "from Cluster c inner join Host h on c.clusterId = h.clusterId "
			+ "where c.clusterId=:clusterId")
	Resource findResource(@Param("clusterId") int clusterId);
	
	@Query("select c from Cluster c where c.datacenterId=:datacenterId")
	List<Cluster> findAllByDatacenterId(@Param("datacenterId") int datacenterId);
	
	@Query("select new com.vmware.vmscheduler.vmschedulerspringboot.entity.AllotedResource(SUM(h.allotedCpuCount),SUM(h.allotedMemorySizeMiB)) "
			+ "from Cluster c inner join Host h on c.clusterId = h.clusterId "
			+ "where c.clusterId=:clusterId")
	AllotedResource findAllotedResource(@Param("clusterId") int clusterId);
}
