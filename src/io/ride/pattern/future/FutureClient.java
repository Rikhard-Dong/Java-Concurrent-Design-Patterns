package io.ride.pattern.future;

/**
 * @author 董凌浩
 * @Date: 2019/5/14 18:04
 */
public class FutureClient {

    public Data request(final String request) {
        final FutureData futureData = new FutureData();

        new Thread(() -> {
            RealData realData = new RealData(request);
            futureData.setRealData(realData);
        }).start();

        return futureData;
    }
}
