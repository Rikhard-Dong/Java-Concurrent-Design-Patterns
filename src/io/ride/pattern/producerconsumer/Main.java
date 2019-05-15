package io.ride.pattern.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 16:49
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);


        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(producer1);
        executor.execute(producer2);
        executor.execute(producer3);
        executor.execute(consumer1);
        executor.execute(consumer2);
        executor.execute(consumer3);

        Thread.sleep(2 * 1000);

        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(5 * 1000);
        executor.shutdown();
    }
}
