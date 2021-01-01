package com.vmware.vmscheduler.vmschedulerspringboot.entity;


public class Resource {
	private Long cpuCount;
	private Long memorySizeMiB;
	
	public Resource(Long cpuCount, Long memorySizeMiB) {
		super();
		this.cpuCount = cpuCount;
		this.memorySizeMiB = memorySizeMiB;
	}

	public Long getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(Long cpuCount) {
		this.cpuCount = cpuCount;
	}
	public Long getMemorySizeMiB() {
		return memorySizeMiB;
	}
	public void setMemorySizeMiB(Long memorySizeMiB) {
		this.memorySizeMiB = memorySizeMiB;
	}

	@Override
	public String toString() {
		return "Resource [cpuCount=" + cpuCount + ", memorySizeMiB=" + memorySizeMiB + "]";
	}
	
}
