package io.ride.pattern.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 董凌浩
 * @company 杭州信牛网络科技有限公司
 * @Date: 2019/5/15 16:37
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;

    private BlockingQueue<PCData> queue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEP_TIME = 100;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data;
        Random r = new Random();
        System.out.println("Start producer id = " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEP_TIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + "put into queue");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("fail to put data " + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }
    }

    public void stop() {
        isRunning = false;
    }

}
