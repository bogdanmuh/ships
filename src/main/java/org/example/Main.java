package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("%s Генератор запустился%n", Thread.currentThread().getName());
        List<CompletableFuture> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futureList.add(CompletableFuture
                    .runAsync(() -> new Path().begin(generateShip()))
                    .thenAccept(s -> System.out.println("end")));
        }
        futureList.forEach(CompletableFuture::join);
    }

    public static Ship generateShip() {
        return new Ship((int) (Math.random() * 100),
                Product.values()[1],
                10);
}