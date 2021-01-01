package com.vmware.vmscheduler.vmschedulerspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VMS_VirtualMachine")
public class VirtualMachine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vm_id")
	private int vmId;
	
	@Column(name="vm_name")
	private String vmName;
	
	@Column(name="cpu_count")
	private int cpuCount;
	
	@Column(name="memory_size_MiB")
	private int memorySizeMiB;
	
	@Column(name="host_id")
	private int hostId;
	
	public VirtualMachine() {
		
	}

	public VirtualMachine(String vmName, int cpuCount, int memorySizeMiB, int hostId) {
		super();
		this.vmName = vmName;
		this.cpuCount = cpuCount;
		this.memorySizeMiB = memorySizeMiB;
		this.hostId = hostId;
	}

	public VirtualMachine(int vmId, String vmName, int cpuCount, int memorySizeMiB, int hostId) {
		super();
		this.vmId = vmId;
		this.vmName = vmName;
		this.cpuCount = cpuCount;
		this.memorySizeMiB = memorySizeMiB;
		this.hostId = hostId;
	}

	public int getVmId() {
		return vmId;
	}

	public void setVmId(int vmId) {
		this.vmId = vmId;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
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

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	@Override
	public String toString() {
		return "VirtualMachine [vmId=" + vmId + ", vmName=" + vmName + ", cpuCount=" + cpuCount + ", memorySizeMiB="
				+ memorySizeMiB + ", hostId=" + hostId + "]";
	}
	
}
