# Master Worker 模式

Master-Worker模式是非常经典的常用的一个并行计算模式，它的核心思想是2类进程协作工作：Master进程和Worker进程。
Master进程负责接收客户端请求, 将一个大的JOB拆分成多个小的JOB交给多个worker并行执行,
如果有十个job, 每个需要1s时间执行, 单线程处理的话可能需要十秒多, 而使用master-worker模式,
十个worker同时执行的话, 则只需要1s多就可以了.

例子可以查看io.ride.pattern.masterworker包下.

Master Worker 应用很广, 比如流行的Web Server,如Nginx,Apache HTTP都存在这种Master-Worker工作模式；离线分布式计算框架Hadoop的JobTracker和TaskTracker，实时流计算框架Strom的Nimbus和Supervisor都涉及到这种思想。