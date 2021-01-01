INSERT INTO VMS_Datacenter (datacenter_id,datacenter_name)
VALUES (101,'WDC-Datacenter')

INSERT INTO VMS_Datacenter (datacenter_id,datacenter_name)
VALUES (102,'CVM-Datacenter')

INSERT INTO VMS_Datacenter (datacenter_id,datacenter_name)
VALUES (103,'Autodeploy')
/* ------------------------------------------------------------------ */
INSERT INTO VMS_Cluster (cluster_id,cluster_name,vms_enabled,datacenter_id)
VALUES (1,'AllHost',true,101)

INSERT INTO VMS_Cluster (cluster_id,cluster_name,vms_enabled,datacenter_id)
VALUES (2,'VSANCluster',true,101)

INSERT INTO VMS_Cluster (cluster_id,cluster_name,vms_enabled,datacenter_id)
VALUES (3,'NVM-VSANCluster',true,101)

INSERT INTO VMS_Cluster (cluster_id,cluster_name,vms_enabled,datacenter_id)
VALUES (4,'UW-Sims-Hosts',true,102)

INSERT INTO VMS_Cluster (cluster_id,cluster_name,vms_enabled,datacenter_id)
VALUES (5,'VCLS-66ESX',true,102)

INSERT INTO VMS_Cluster (cluster_id,cluster_name,vms_enabled,datacenter_id)
VALUES (6,'ZSTIO-Cluster',true,103)
/* ------------------------------------------------------------------ */
INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (1,'hs2-g01.eng.vmware.com',0,20,20,0,0,1)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (2,'hs2-g02.eng.vmware.com',0,40,40,0,0,1)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (3,'hs2-g03.eng.vmware.com',0,20,20,0,0,2)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (4,'hs2-g04.eng.vmware.com',0,40,40,0,0,2)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (5,'hs2-g05.eng.vmware.com',0,20,20,0,0,3)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (6,'hs2-g06.eng.vmware.com',0,40,50,0,0,3)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (7,'hs2-g07.eng.vmware.com',0,20,20,0,0,4)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (8,'hs2-g08.eng.vmware.com',0,20,50,0,0,4)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (9,'hs2-g09.eng.vmware.com',0,20,20,0,0,5)

INSERT INTO VMS_Host (host_id,host_name,no_of_vms,cpu_count,memory_size_MiB,alloted_cpu_count,alloted_memory_size_MiB,cluster_id)
VALUES (10,'hs2-g10.eng.vmware.com',0,20,40,0,0,6)
/* ------------------------------------------------------------------ */
INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (1,'tinyLinux01',4,4,1)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (2,'tinyLinux02',2,8,1)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (3,'windows01',4,8,2)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (4,'windows02',2,8,2)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (5,'cloudVm01',4,4,3)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (6,'cloudVm02',2,8,3)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (7,'cloudVm01',4,4,4)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (8,'cloudVm02',2,8,4)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (9,'Prod-Webapp02',2,2,5)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (10,'webapp-emlm-01',4,8,6)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (11,'webapp-emlm-02',2,16,6)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (12,'webapp-emlm-01',4,8,7)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (13,'webapp-emlm-02',8,16,8)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (14,'webapp-emlm-01',4,8,9)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (15,'webapp-emlm-02',2,16,10)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (16,'webapp-emlm-01',2,8,10)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (17,'webapp-emlm-02',2,8,10)

INSERT INTO VMS_VirtualMachine (vm_id,vm_name,cpu_count,memory_size_MiB,host_id)
VALUES (18,'Prod-Webapp08',8,10,2)



