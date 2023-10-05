package org.example;

public class Ship {
    private int count;
    private Product product;
    public Ship(int count, Product product) {
        this.count = count;
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }
}
