package io.ride.pattern.future;

import java.util.concurrent.*;

/**
 * JDK内部实现的future模式
 *
 * @author 董凌浩
 * @Date: 2019/5/15 10:52
 */
public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(new InnerRealData("1"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);
        System.out.println("请求完毕, 等待执行结果");
        try {
            System.out.println("等待过程中执行一些其他操作");
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 如果此时call方法还没有完成, 则future.get()仍然会等待
        System.out.println("请求结果 => " + future.get());
        executor.shutdown();
    }
}

/**
 * 构造非常快, 业务逻辑被移动call方法中, 并返回
 */
class InnerRealData implements Callable<String> {

    private String param;

    public InnerRealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // 一个复杂的操作, 较为耗时
            sb.append(this.param);
            Thread.sleep(100);
        }
        System.out.println("内部逻辑完成");
        return sb.toString();
    }
}
