package com.pb.gvozdev.hw2;

import java.util.Scanner;

public class Interval {

    public static void main(String[] args) {
        System.out.println("Введите целое число");

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        if(number >= 0 && number<= 14)
            System.out.println("[0 - 14]");

        else if(number >= 15 && number<= 35)
            System.out.println("[15 - 35]");

        else if(number >= 36 && number<= 50)
            System.out.println("[36 - 50]");

        else if(number >= 51 && number<= 100)
            System.out.println("[51 - 100]");

        else System.out.println(
         "Число не попадает ни в один из имеющихся промежутков"
            );

    }
}
