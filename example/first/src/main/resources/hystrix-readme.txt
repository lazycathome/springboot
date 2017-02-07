超时时间（默认1000ms，单位：ms）
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds
在调用方配置，被该调用方的所有方法的超时时间都是该值，优先级低于下边的指定配置
hystrix.command.HystrixCommandKey.execution.isolation.thread.timeoutInMilliseconds
在调用方配置，被该调用方的指定方法（HystrixCommandKey方法名）的超时时间是该值
线程池核心线程数
hystrix.threadpool.default.coreSize（默认为10）
Queue
hystrix.threadpool.default.maxQueueSize（最大排队长度。默认-1，使用SynchronousQueue。其他值则使用 LinkedBlockingQueue。如果要从-1换成其他值则需重启，即该值不能动态调整，若要动态调整，需要使用到下边这个配置）
hystrix.threadpool.default.queueSizeRejectionThreshold（排队线程数量阈值，默认为5，达到时拒绝，如果配置了该选项，队列的大小是该队列）
注意：如果maxQueueSize=-1的话，则该选项不起作用
断路器
hystrix.command.default.circuitBreaker.requestVolumeThreshold（当在配置时间窗口内达到此数量的失败后，进行短路。默认20个）
For example, if the value is 20, then if only 19 requests are received in the rolling window (say a window of 10 seconds) the circuit will not trip open even if all 19 failed.
hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds（短路多久以后开始尝试是否恢复，默认5s）
hystrix.command.default.circuitBreaker.errorThresholdPercentage（出错百分比阈值，当达到此阈值后，开始短路。默认50%）
fallback
hystrix.command.default.fallback.isolation.semaphore.maxConcurrentRequests（调用线程允许请求HystrixCommand.GetFallback()的最大数量，默认10。超出时将会有异常抛出，注意：该项配置对于THREAD隔离模式也起作用）

五、Metrics storage and Dashboard

仅仅记录hystrix1.5.0及其后续版本，之前的版本的数据结构不一样。

http://www.ahlinux.com/java/18235.html