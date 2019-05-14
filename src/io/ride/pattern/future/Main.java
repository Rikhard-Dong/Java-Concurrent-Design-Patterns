package io.ride.pattern.future;

/**
 * @author 董凌浩
 * @Date: 2019/5/14 18:05
 */
public class Main {
    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data data = futureClient.request("hello world");
        System.out.println("请求发送成功");
        String request = data.getRequest();
        System.out.println(request);
    }
}
