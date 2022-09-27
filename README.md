# Virtual-Machine-Scheduler

- Implemented a vector bin packing algorithm for optimal virtual machine placement to minimize the active physical machines and the number of migrations for physical machine consolidations with the objective of reducing the energy consumption in a data center significantly.
- Built a UI portal to demo the algorithm that also allows performing CRUD operations on an inventory of objects like datacenter, cluster, host, and a virtual machine with RBAC support.
- Solution Design and Approach

  ![scheduler-logic](https://github.com/yadavpa1/Virtual-Machine-Scheduler/blob/47debddd5aff5e579fe3bfdca15aceacd1ef30f6/scheduler_logic.png)
  Here, numbers on the bins imply the load (i.e. CPU count, Memory count, etc.) of the VM.
  
- VM Migration is implemented to consolidate VMs into a smaller number of hosts, leading to better host utilization, which in turn reduces power consumption, as after consolidation hosts hosting no VMs can be shutdown. The UI portal displays the Power On/Off state of these hosts.

