package io.ride.pattern.producerconsumer;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 16:35
 */
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
