package org.example;

public class Ship {
    private final int count;
    private final Product product;
    private final int speed;

    public Ship(int count, Product product, int speed) {
        this.count = count;
        this.product = product;
        this.speed = speed;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    public int getSpeed() {
        return speed;
    }
}
