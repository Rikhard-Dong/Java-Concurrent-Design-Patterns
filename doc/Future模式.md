# Future 模式

future 模式有点类似于网上购物的过程, 客户挑选好商品下单(客户端发送一个request请求),
商家需要处理订单, 拣货, 配送等, 需要较长的时间处理(服务器处理请求需要一定时间),
在这个过程中, 客户可以处理一些其他事情, 而不必干等着商品送过来.

代码实现可以查看io.ride.pattern.future包下

在jdk内部也实现了future模式, 可以查看juc包下的FutureTask类, 例子可以查看io.ride.pattern.future.Main2类