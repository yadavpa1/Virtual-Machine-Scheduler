package com.vmware.vmscheduler.vmschedulerspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmware.vmscheduler.vmschedulerspringboot.entity.Datacenter;
import com.vmware.vmscheduler.vmschedulerspringboot.entity.Resource;

public interface DatacenterRepository extends JpaRepository<Datacenter, Integer>{
	
	@Query("select  COUNT(*) from  Cluster c where c.datacenterId=:datacenterId")
	  int findNoOfClusters(@Param("datacenterId") int datacenterId);
	
	@Query("select COUNT(h.hostId) from Datacenter d inner join Cluster c on d.datacenterId = c.datacenterId "
			+ "inner join Host h on c.clusterId = h.clusterId "
			+ "where d.datacenterId=:datacenterId")
	int findNoOfHosts(@Param("datacenterId") int datacenterId);
	
	@Query("select COUNT(v.vmId) from Datacenter d inner join Cluster c on d.datacenterId = c.datacenterId "
			+ "inner join Host h on c.clusterId = h.clusterId "
			+ "inner join VirtualMachine v on h.hostId = v.hostId "
			+ "where d.datacenterId=:datacenterId")
	int findNoOfVms(@Param("datacenterId") int datacenterId);
	
	@Query("select new com.vmware.vmscheduler.vmschedulerspringboot.entity.Resource(SUM(h.cpuCount),SUM(h.memorySizeMiB)) "
			+ "from Datacenter d inner join Cluster c on d.datacenterId = c.datacenterId "
			+ "inner join Host h on c.clusterId = h.clusterId "
			+ "where d.datacenterId=:datacenterId")
	Resource findResource(@Param("datacenterId") int datacenterId);
	
}
