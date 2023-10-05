package org.example;

import java.util.HashMap;

public class PierLoader extends Thread {
    private static HashMap<Product, Pier> piers = new HashMap<>();
    private static Tunnel tunnel = new Tunnel();

    static {
        for(Product product : Product.values()) {
            Pier pier = new Pier();
            pier.start();
            piers.put(product, pier);
        }
    }

    @Override
    public void run() {
        System.out.println("Балансировщику готов");
        while (true) {
            if (!tunnel.isEmpty()) {
                Ship ship = tunnel.poll();
                System.out.println(String.format("прибыл к балансировщику корабль с %s прибыл", ship.getProduct().name()));
                piers.get(ship.getProduct()).add(ship);
            }

        }
    }
}
