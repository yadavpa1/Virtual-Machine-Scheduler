package com.vmware.vmscheduler.vmschedulerspringboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VMS_Host")
public class Host {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="host_id")
	private int hostId;
	
	@Column(name="host_name")
	private String hostName;
	
	@Column(name="no_of_vms")
	private int noOfVms;
	
	@Column(name="cpu_count")
	private int cpuCount;
	
	@Column(name="memory_size_MiB")
	private int memorySizeMiB;
	
	@Column(name="alloted_cpu_count")
	private int allotedCpuCount;
	
	@Column(name="alloted_memory_size_MiB")
	private int allotedMemorySizeMiB;
	
	@Column(name="cluster_id")
	private int clusterId;
	
	@Transient List<VirtualMachine> vmList = new ArrayList<>();
	
	public Host() {
		
	}

	public Host(String hostName, int noOfVms, int cpuCount, int memorySizeMiB, int allotedCpuCount,
			int allotedMemorySizeMiB, int clusterId) {
		super();
		this.hostName = hostName;
		this.noOfVms = noOfVms;
		this.cpuCount = cpuCount;
		this.memorySizeMiB = memorySizeMiB;
		this.allotedCpuCount = allotedCpuCount;
		this.allotedMemorySizeMiB = allotedMemorySizeMiB;
		this.clusterId = clusterId;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getNoOfVms() {
		return noOfVms;
	}

	public void setNoOfVms(int noOfVms) {
		this.noOfVms = noOfVms;
	}

	public int getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}

	public int getMemorySizeMiB() {
		return memorySizeMiB;
	}

	public void setMemorySizeMiB(int memorySizeMiB) {
		this.memorySizeMiB = memorySizeMiB;
	}

	public int getAllotedCpuCount() {
		return allotedCpuCount;
	}

	public void setAllotedCpuCount(int allotedCpuCount) {
		this.allotedCpuCount = allotedCpuCount;
	}

	public int getAllotedMemorySizeMiB() {
		return allotedMemorySizeMiB;
	}

	public void setAllotedMemorySizeMiB(int allotedMemorySizeMiB) {
		this.allotedMemorySizeMiB = allotedMemorySizeMiB;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}

	public List<VirtualMachine> getVmList() {
		return vmList;
	}

	public void setVmList(List<VirtualMachine> vmList) {
		this.vmList = vmList;
	}

	@Override
	public String toString() {
		return "Host [hostId=" + hostId + ", hostName=" + hostName + ", noOfVms=" + noOfVms + ", cpuCount=" + cpuCount
				+ ", memorySizeMiB=" + memorySizeMiB + ", allotedCpuCount=" + allotedCpuCount
				+ ", allotedMemorySizeMiB=" + allotedMemorySizeMiB + ", clusterId=" + clusterId + ", vmList=" + vmList
				+ "]";
	}
	
	
}
