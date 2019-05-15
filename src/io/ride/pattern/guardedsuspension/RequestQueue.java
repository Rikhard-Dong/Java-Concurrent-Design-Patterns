package io.ride.pattern.guardedsuspension;

import java.util.LinkedList;

/**
 * 保存客户端请求队列
 *
 * @author 董凌浩
 * @Date: 2019/5/15 14:06
 */
public class RequestQueue {

    private LinkedList<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                // 如果当前queue中没有可以获取的request, 则wait, 等待新的request加入
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void addRequest(Request request) {
        queue.add(request);
        notifyAll();
    }
}
