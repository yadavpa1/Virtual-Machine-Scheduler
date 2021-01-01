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
@Table(name="VMS_Datacenter")
public class Datacenter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="datacenter_id")
	private int datacenterId;
	
	@Column(name="datacenter_name")
	private String datacenterName;
	
	@Transient int noOfHosts;
	@Transient int noOfClusters;
	@Transient int noOfVms;
	@Transient Resource resource;
	@Transient List<Cluster> clusterList = new ArrayList<>();
	
	public Datacenter() {
		
	}

	public Datacenter(String datacenterName) {
		super();
		this.datacenterName = datacenterName;
	}

	public int getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(int datacenterId) {
		this.datacenterId = datacenterId;
	}

	public String getDatacenterName() {
		return datacenterName;
	}

	public void setDatacenterName(String datacenterName) {
		this.datacenterName = datacenterName;
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

	public List<Cluster> getClusterList() {
		return clusterList;
	}

	public void setClusterList(List<Cluster> clusterList) {
		this.clusterList = clusterList;
	}

	@Override
	public String toString() {
		return "Datacenter [datacenterId=" + datacenterId + ", datacenterName=" + datacenterName + ", noOfHosts="
				+ noOfHosts + ", noOfClusters=" + noOfClusters + ", noOfVms=" + noOfVms + ", resource=" + resource
				+ ", clusterList=" + clusterList + "]";
	}
	
	
}
