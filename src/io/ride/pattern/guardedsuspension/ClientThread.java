package io.ride.pattern.guardedsuspension;

/**
 * 客户端进程
 *
 * @author 董凌浩
 * @Date: 2019/5/15 14:06
 */
public class ClientThread extends Thread {

    private RequestQueue requestQueue;

    public ClientThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID: " + i + " Thread Name: " + Thread.currentThread().getName());
            requestQueue.addRequest(request);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Client Thread Name is " + Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " request end");
    }
}
