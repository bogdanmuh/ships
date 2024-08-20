package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Pier extends Thread {
    public synchronized void unload(Ship ship) {
        System.out.printf("%s Корабль с %s прибыл%n",
                Thread.currentThread().getName(),
                ship.getProduct().name());
        try {
            Thread.sleep(ship.getCount() * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s Разгрузили корабль с %s за %d секунд%n",
                Thread.currentThread().getName(),
                ship.getProduct().name(),
                ship.getCount() / 10);
    }


}
