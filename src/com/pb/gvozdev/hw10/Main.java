package com.pb.gvozdev.hw10;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        NumBox<Integer> numBox = new NumBox<>(8);
        numBox.add(1);
        numBox.add(2);
        numBox.add(3);
        numBox.add(4);
        numBox.add(5);
        numBox.add(5);
        numBox.add(5);
        numBox.add(23);

        System.out.println("-> NumBox<Integer> :");
        System.out.println("\nMethod add: " + Arrays.toString(numBox.arrayObj));
        System.out.println("Method get: "+numBox.get(0));
        System.out.println("Method length: "+numBox.length());
        System.out.println("Method average: "+numBox.average());
        System.out.println("Method max: "+numBox.max());
        System.out.println("Method sum: "+numBox.sum());

        NumBox<Float> numBoxF = new NumBox<>(6);
        numBoxF.add(1.1f);
        numBoxF.add(2.3f);
        numBoxF.add(3.1f);
        numBoxF.add(6.5f);
        numBoxF.add(2.9f);
        numBoxF.add(4.4f);

        System.out.println("\n-> NumBox<Float> :");
        System.out.println("\nMethod add: " + Arrays.toString(numBoxF.arrayObj));
        System.out.println("Method get: "+numBoxF.get(0));
        System.out.println("Method length: "+numBoxF.length());
        System.out.println("Method average: "+numBoxF.average());
        System.out.println("Method max: "+numBoxF.max());
        System.out.println("Method sum: "+numBoxF.sum());

        NumBox<Double> numBoxD = new NumBox<>(5);
        numBoxD.add(0.2);
        numBoxD.add(2.2);
        numBoxD.add(3.1);
        numBoxD.add(6.5);
        numBoxD.add(5.9);
        numBoxD.add(4.8);

        System.out.println("\n-> NumBox<Double> :");
        System.out.println("\nMethod add: " + Arrays.toString(numBoxD.arrayObj));
        System.out.println("Method get: "+numBoxD.get(0));
        System.out.println("Method length: "+numBoxD.length());
        System.out.println("Method average: "+numBoxD.average());
        System.out.println("Method max: "+numBoxD.max());
        System.out.println("Method sum: "+numBoxD.sum());

    }
}
