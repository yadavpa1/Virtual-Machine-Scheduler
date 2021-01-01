CREATE TABLE VMS_Datacenter(
	datacenter_id int NOT NULL AUTO_INCREMENT,
	datacenter_name varchar(255),
	PRIMARY KEY(datacenter_id)
	)
	
CREATE TABLE VMS_Cluster(
	cluster_id int NOT NULL AUTO_INCREMENT,
	cluster_name varchar(255),
	vms_enabled BOOLEAN,
	datacenter_id int,
	PRIMARY KEY(cluster_id),
	FOREIGN KEY(datacenter_id) REFERENCES VMS_Datacenter(datacenter_id)
	ON DELETE CASCADE
	)
	
CREATE TABLE VMS_Host(
	host_id int NOT NULL AUTO_INCREMENT,
	host_name varchar(255),
	no_of_vms int,
	cpu_count int,
	memory_size_MiB float,
	alloted_cpu_count int,
	alloted_memory_size_MiB float,
	cluster_id int,
	PRIMARY KEY(host_id),
	FOREIGN KEY(cluster_id) REFERENCES VMS_Cluster(cluster_id)
	ON DELETE CASCADE
	)

CREATE TABLE VMS_VirtualMachine(
	vm_id int NOT NULL AUTO_INCREMENT,
	vm_name varchar(255),
	cpu_count int,
	memory_size_MiB float,
	host_id int,
	PRIMARY KEY(vm_id),
	FOREIGN KEY(host_id) REFERENCES VMS_Host(host_id)
	ON DELETE CASCADE
	)
	
CREATE TABLE VMS_Users(
	user_id int NOT NULL AUTO_INCREMENT,
	username varchar(255),
	password varchar(255),
	roleType char(1),
	PRIMARY KEY(user_id)
	)