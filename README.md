# SpringCloud-Learning
springcloud全家桶

eureka 80 8001 8002 7001 7002
zookeeper 80 8004
consul  80 8006

C 强一致性
A 高可用性
P 分区容错性

最多只能满足两个
CAP理论的核心是： 一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求
因此，根据CAP原理及那个NoSQL数据库分成满足CA原则/满足CP原则和满足AP原则这三大类

CA - 单点集群，满足一致性，可用性的系统，通常可扩展行不是很大
Zookeeper、consul - CP - 满足一致性，分成容忍的系统，通常性能不是很高
Eureka AP - 满足可用 性，分区容忍性系统，通常对一致性要求低一些

