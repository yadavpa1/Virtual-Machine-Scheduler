DELIMITER //
CREATE PROCEDURE getVCenterInfo()
BEGIN
	SELECT COUNT(no_of_datacenters, no_of_hosts, no_of_clusters, no_of_vms, cpu_count,memory_size_MiB
	FROM VMS_Datacenter;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE getDatacenterInfo(IN d_id INT)
BEGIN
	SELECT datacenter_name, no_of_hosts, no_of_clusters, no_of_vms, cpu_count,memory_size_MiB
	FROM VMS_Datacenter
	WHERE datacenter_id = d_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getClusterInfo(IN c_id INT)
BEGIN
	SELECT cluster_name, no_of_hosts, no_of_vms, cpu_count,memory_size_MiB, vms_enabled,datacenter_id
	FROM VMS_Cluster
	WHERE cluster_id = c_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getHostInfo(IN h_id INT)
BEGIN
	SELECT host_name, no_of_vms, cpu_count,memory_size_MiB, alloted_cpu_count,alloted_memory_size_MiB,cluster_id
	FROM VMS_Host
	WHERE host_id = h_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getVMInfo(IN v_id INT)
BEGIN
	SELECT vm_name, cpu_count,memory_size_MiB,host_id
	FROM VMS_VirtualMachine
	WHERE vm_id = v_id;
END //
DELIMITER ;
/*------------------------------------------------------------*/
DELIMITER //
CREATE TRIGGER updateHostOnVMInsert
AFTER INSERT
ON VMS_VirtualMachine 
FOR EACH ROW
BEGIN
	UPDATE VMS_Host
	SET no_of_vms = no_of_vms + 1,
	alloted_cpu_count = alloted_cpu_count + NEW.cpu_count,
	alloted_memory_size_MiB = alloted_memory_size_MiB + NEW.memory_size_MiB
	WHERE host_id = NEW.host_id;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER updateHostOnVMUpdate
AFTER UPDATE
ON VMS_VirtualMachine 
FOR EACH ROW
BEGIN
	UPDATE VMS_Host
	SET alloted_cpu_count = alloted_cpu_count - OLD.cpu_count + NEW.cpu_count,
	alloted_memory_size_MiB = alloted_memory_size_MiB - OLD.memory_size_MiB + NEW.memory_size_MiB
	WHERE host_id = NEW.host_id;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER updateHostOnVMDelete
AFTER DELETE
ON VMS_VirtualMachine 
FOR EACH ROW
BEGIN
	UPDATE VMS_Host
	SET no_of_vms = no_of_vms - 1,
	alloted_cpu_count = alloted_cpu_count - OLD.cpu_count,
	alloted_memory_size_MiB = alloted_memory_size_MiB - OLD.memory_size_MiB
	WHERE host_id = OLD.host_id;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER updateHostOnVMUpdate
AFTER UPDATE
ON VMS_VirtualMachine 
FOR EACH ROW
BEGIN
	UPDATE VMS_Host
	SET alloted_cpu_count = alloted_cpu_count - OLD.cpu_count + NEW.cpu_count,
	alloted_memory_size_MiB = alloted_memory_size_MiB - OLD.memory_size_MiB + NEW.memory_size_MiB
	WHERE host_id = NEW.host_id;
END //
DELIMITER ;

