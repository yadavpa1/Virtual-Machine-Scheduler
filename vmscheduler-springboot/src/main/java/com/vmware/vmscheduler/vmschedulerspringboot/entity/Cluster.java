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
@Table(name="VMS_Cluster")
public class Cluster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cluster_id")
	private int clusterId;
	
	@Column(name="cluster_name")
	private String clusterName;
	
	@Column(name="vms_enabled")
	private boolean vmsEnabled;
	
	@Column(name="datacenter_id")
	private int datacenterId;
	
	@Transient int noOfHosts;
	@Transient int noOfVms;
	@Transient Resource resource;
	@Transient AllotedResource allotedResource;
	@Transient List<Host> hostList = new ArrayList<>();
	
	public Cluster() {
		
	}

	public Cluster(String clusterName, boolean vmsEnabled, int datacenterId) {
		super();
		this.clusterName = clusterName;
		this.vmsEnabled = vmsEnabled;
		this.datacenterId = datacenterId;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public boolean isVmsEnabled() {
		return vmsEnabled;
	}

	public void setVmsEnabled(boolean vmsEnabled) {
		this.vmsEnabled = vmsEnabled;
	}

	public int getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(int datacenterId) {
		this.datacenterId = datacenterId;
	}

	public int getNoOfHosts() {
		return noOfHosts;
	}

	public void setNoOfHosts(int noOfHosts) {
		this.noOfHosts = noOfHosts;
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

	public AllotedResource getAllotedResource() {
		return allotedResource;
	}

	public void setAllotedResource(AllotedResource allotedResource) {
		this.allotedResource = allotedResource;
	}

	public List<Host> getHostList() {
		return hostList;
	}

	public void setHostList(List<Host> hostList) {
		this.hostList = hostList;
	}

	@Override
	public String toString() {
		return "Cluster [clusterId=" + clusterId + ", clusterName=" + clusterName + ", vmsEnabled=" + vmsEnabled
				+ ", datacenterId=" + datacenterId + ", noOfHosts=" + noOfHosts + ", noOfVms=" + noOfVms + ", resource="
				+ resource + ", allotedResource=" + allotedResource + ", hostList=" + hostList + "]";
	}
	
}
