package io.ride.pattern.immutable;

/**
 * 不变模式例子
 *
 * @author 董凌浩
 * @Date: 2019/5/15 14:47
 */
public final class Product {
    private final String no;

    private final String name;

    private final double price;

    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
