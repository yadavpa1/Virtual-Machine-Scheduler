DELIMITER //
CREATE TRIGGER updateHostOnVMUpdate
AFTER UPDATE
ON VMS_VirtualMachine 
FOR EACH ROW
BEGIN
	IF OLD.host_id <> NEW.host_id THEN
		UPDATE VMS_Host
		SET no_of_vms = no_of_vms - 1,
		alloted_cpu_count = alloted_cpu_count - OLD.cpu_count,
		alloted_memory_size_MiB = alloted_memory_size_MiB - OLD.memory_size_MiB
		WHERE host_id = OLD.host_id;
		UPDATE VMS_Host
		SET no_of_vms = no_of_vms + 1,
		alloted_cpu_count = alloted_cpu_count + OLD.cpu_count,
		alloted_memory_size_MiB = alloted_memory_size_MiB + OLD.memory_size_MiB
		WHERE host_id = NEW.host_id;
	ELSEIF OLD.host_id = NEW.host_id THEN
		UPDATE VMS_Host
		SET alloted_cpu_count = alloted_cpu_count - OLD.cpu_count + NEW.cpu_count,
		alloted_memory_size_MiB = alloted_memory_size_MiB - OLD.memory_size_MiB + NEW.memory_size_MiB
		WHERE host_id = NEW.host_id;
	END IF;
END //
DELIMITER ;