package com.vmware.vmscheduler.vmschedulerspringboot.entity;

import java.util.List;

public class VCenter {
	private String vcenterName;
	private int noOfDatacenters;
	private int noOfHosts;
	private int noOfClusters;
	private int noOfVms;
	private Resource resource;
	private List<Datacenter> inventory;
	
	public String getVcenterName() {
		return vcenterName;
	}
	public void setVcenterName(String vcenterName) {
		this.vcenterName = vcenterName;
	}
	public int getNoOfDatacenters() {
		return noOfDatacenters;
	}
	public void setNoOfDatacenters(int noOfDatacenters) {
		this.noOfDatacenters = noOfDatacenters;
	}
	public int getNoOfHosts() {
		return noOfHosts;
	}
	public void setNoOfHosts(int noOfHosts) {
		this.noOfHosts = noOfHosts;
	}
	public int getNoOfClusters() {
		return noOfClusters;
	}
	public void setNoOfClusters(int noOfClusters) {
		this.noOfClusters = noOfClusters;
	}
	public int getNoOfVms() {
		return noOfVms;
	}
	public void setNoOfVms(int noOfVms) {
		this.noOfVms = noOfVms;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public List<Datacenter> getInventory() {
		return inventory;
	}
	public void setInventory(List<Datacenter> inventory) {
		this.inventory = inventory;
	}
	

}
