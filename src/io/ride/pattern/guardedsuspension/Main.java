package io.ride.pattern.guardedsuspension;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 14:20
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        for (int i = 0; i < 10; i++) {
            new ServerThread("ServerThread_" + i, requestQueue).start();
        }

        for (int i = 0; i < 10; i++) {
            new ClientThread("ClientThread_" + i, requestQueue).start();
        }
    }
}
