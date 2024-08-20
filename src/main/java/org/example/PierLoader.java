package org.example;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class PierLoader extends Thread {
    private static final ConcurrentHashMap<Product, Pier> piers = new ConcurrentHashMap<>();

    static {
        for (Product product : Product.values()) {
            piers.put(product, new Pier());
        }
    }

    public void add(Ship ship) {
        System.out.printf("%s прибыл к балансировщику корабль с %s %n",
                Thread.currentThread().getName(),
                ship.getProduct().name());
        piers.get(ship.getProduct()).unload(ship);
    }
}
