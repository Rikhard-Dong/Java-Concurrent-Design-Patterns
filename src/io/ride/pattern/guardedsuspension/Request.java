package io.ride.pattern.guardedsuspension;

/**
 * 模拟请求
 *
 * @author 董凌浩
 * @Date: 2019/5/15 14:04
 */
public class Request {

    private String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
