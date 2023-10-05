package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Pier extends Thread {
    private Queue<Ship> queue = new LinkedList<>();

    @Override
    public void run() {
        System.out.println(String.format("Причал готов "));
        while(true) {
           if (!queue.isEmpty()) {
               Ship ship = queue.poll();
               System.out.println(String.format("Корабль с %s прибыл", ship.getProduct().name()));
               try {
                   Thread.sleep(ship.getCount() * 100L);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println(String.format("Разгрузили корабль с %s за %d секунд", ship.getProduct().name(), ship.getCount() / 10));
           } else {
               try {
                   Thread.sleep(1000L);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }

        }
    }
    public void add (Ship ship) {
        queue.add(ship);
    }


}
