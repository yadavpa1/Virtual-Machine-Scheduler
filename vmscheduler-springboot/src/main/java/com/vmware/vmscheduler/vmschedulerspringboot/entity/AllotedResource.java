package com.vmware.vmscheduler.vmschedulerspringboot.entity;

public class AllotedResource {
	private Long allotedCpuCount;
	private Long allotedMemorySizeMiB;
	
	public AllotedResource(Long allotedCpuCount, Long allotedMemorySizeMiB) {
		super();
		this.allotedCpuCount = allotedCpuCount;
		this.allotedMemorySizeMiB = allotedMemorySizeMiB;
	}

	public Long getAllotedCpuCount() {
		return allotedCpuCount;
	}

	public void setAllotedCpuCount(Long allotedCpuCount) {
		this.allotedCpuCount = allotedCpuCount;
	}

	public Long getAllotedMemorySizeMiB() {
		return allotedMemorySizeMiB;
	}

	public void setAllotedMemorySizeMiB(Long allotedMemorySizeMiB) {
		this.allotedMemorySizeMiB = allotedMemorySizeMiB;
	}

	@Override
	public String toString() {
		return "AllotedResource [allotedCpuCount=" + allotedCpuCount + ", allotedMemorySizeMiB=" + allotedMemorySizeMiB
				+ "]";
	}
	
	
}
