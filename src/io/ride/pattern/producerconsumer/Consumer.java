package io.ride.pattern.producerconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 16:44
 */
public class Consumer implements Runnable {

    private static final int SLEEP_TIME = 1000;

    private BlockingQueue<PCData> queue;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                PCData data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    int re = data.getIntData() * data.getIntData();
                    System.out.println(MessageFormat.format("{0} * {0} = {1}", data.getIntData(), re));
                    Thread.sleep(r.nextInt(SLEEP_TIME));
                } else {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }
    }
}
