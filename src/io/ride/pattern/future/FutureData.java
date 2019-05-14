package io.ride.pattern.future;

/**
 * @author 董凌浩
 * @Date: 2019/5/14 18:01
 */
public class FutureData implements Data {
    private RealData realData;

    private boolean isReady = false;


    @Override
    public synchronized String getRequest() {
        while (!this.isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.getRequest();
    }

    public synchronized void setRealData(RealData realData) {
        if (this.isReady) {
            return;
        }
        this.realData = realData;
        this.isReady = true;
        notify();
    }
}
