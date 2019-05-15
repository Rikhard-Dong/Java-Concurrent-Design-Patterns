package io.ride.pattern.masterworker;

import java.util.HashMap;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 11:18
 */
public class Worker implements Runnable {
    private long id;
    private String name;

    private ConcurrentLinkedQueue<Task> workQueue;
    private ConcurrentHashMap<Long, Object> results;

    public Worker(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResults(ConcurrentHashMap<Long, Object> results) {
        this.results = results;
    }


    @Override
    public void run() {
        while (true) {
            Task task = workQueue.poll();
            if (task == null) {
                break;
            }
            long start = System.currentTimeMillis();
            long result = handle(task);
            System.out.println(this.name + " handle " + task.getName() + " success . result is " + result + " cost time : " + (System.currentTimeMillis() - start));
        }
    }

    /**
     * 具体业务处理
     *
     * @param task
     * @return
     */
    private long handle(Task task) {
        try {
            // 模拟耗时处理
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextLong();
    }
}
