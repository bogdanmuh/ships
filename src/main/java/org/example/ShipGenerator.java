package org.example;

public class ShipGenerator extends Thread {
    private Tunnel tunnel = new Tunnel();
    public static Ship generateShip(){
        return new Ship((int)(Math.random() * 100),
                Product.values()[(int)(Math.random() * Product.values().length)]);
    }
    @Override
    public void run() {
        System.out.println(String.format("Генератор запустился"));
        while (true) {
            if(!tunnel.isfull()) {
                Ship ship = generateShip();
                System.out.println(String.format("корабль с %s count %d находиться в туннеле", ship.getProduct().name(), ship.getCount()));
                tunnel.add(ship);
            } else {
                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
