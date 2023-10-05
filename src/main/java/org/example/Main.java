package org.example;

public class Main {


    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество доступных ядер: " + cores);

        ShipGenerator shipGenerator = new ShipGenerator ();
        shipGenerator.start();
        PierLoader pierLoader = new PierLoader();
        pierLoader.start();
    }
}