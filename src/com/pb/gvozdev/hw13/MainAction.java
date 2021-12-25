package com.pb.gvozdev.hw13;

public class MainAction {

    public static void main(String[] args) throws Exception {

        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        new Thread(producer,"producer").start();

        Consumer consumer = new Consumer(buffer);
        new Thread(consumer,"consumer").start();

        System.out.println("Стартовали все потоки");


    }
}
