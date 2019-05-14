package io.ride.pattern.future;

/**
 * @author 董凌浩
 * @Date: 2019/5/14 17:58
 */
public class RealData implements Data {
    private String result;

    public RealData(String request) {
        System.out.println("根据" + request + "查询请求需要很长时间");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完成, 获取结果");
        this.result = "查询结果";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
