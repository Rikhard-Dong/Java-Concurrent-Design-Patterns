# Guarded Suspension 模式

Guarded Suspension 模式意味暂停保护模式 当客户端请求数量超出服务器处理能力的时候, 
又不能丢弃请求, 只能将一部分的请求放入缓存队列中,服务器从缓存队列中获取请求,
避免了服务器应请求过多而崩溃.

例子查看io.ride.pattern.guardedsuspension包下.

如果需要返回结果, 则可以和Future模式相结合 