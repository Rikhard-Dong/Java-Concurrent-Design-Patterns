package io.ride.pattern.guardedsuspension;

/**
 * 服务端进程
 *
 * @author 董凌浩
 * @Date: 2019/5/15 14:07
 */
public class ServerThread extends Thread {
    private RequestQueue requestQueue;

    public ServerThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }
}
