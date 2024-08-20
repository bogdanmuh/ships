package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {


    public static final Tunnel tunnel = Tunnel.getInstance(); //  нужно только для  генерации

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("%s Генератор запустился%n", Thread.currentThread().getName());
        List<CompletableFuture> futureList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (!tunnel.isfull()) { //  нужно только для  генерации
                futureList.add(CompletableFuture
                        .runAsync(() -> new Path().begin(generateShip()))
                        .thenAccept(s -> System.out.println("end")));
            } else {
                System.out.println("A");
                try {
                    final Object lock = tunnel.getLock();
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        futureList.forEach(CompletableFuture::join);
    }

    public static Ship generateShip() {
        return new Ship((int) (Math.random() * 100),
                Product.values()[1],
                10);
    }
///(int) (Math.random() * Product.values().length)
}