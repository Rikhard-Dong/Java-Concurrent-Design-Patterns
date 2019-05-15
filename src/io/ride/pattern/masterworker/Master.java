package io.ride.pattern.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 11:18
 */
public class Master {

    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

    private Map<Long, Thread> workers = new HashMap<>();

    private ConcurrentHashMap<Long, Object> results = new ConcurrentHashMap<>();

    public Master(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker(i, "Worker-" + i);
            worker.setResults(results);
            worker.setWorkQueue(workQueue);

            workers.put(Long.valueOf(i), new Thread(worker));
        }
    }

    /**
     * 提交任务
     *
     * @param task
     */
    public void submit(Task task) {
        workQueue.add(task);
    }

    /**
     * 启动worker
     */
    public void start() {
        for (Map.Entry<Long, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }

    /**
     * 判断所有的worker是否完成
     *
     * @return
     */
    public boolean isComplete() {
        for (Map.Entry<Long, Thread> entry : workers.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public long getSumResult() {
        long value = 0;
        for (Map.Entry<Long, Object> entry : results.entrySet()) {
            value += (Long) entry.getValue();
        }
        return value;
    }
}
