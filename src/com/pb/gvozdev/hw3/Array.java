package com.pb.gvozdev.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        int[] array = new int[10];
        int moreZeroSum = 0;
        int counter = 0;
        int sum = 0;
        System.out.println("Введите поочереди 10 целых чисел");

        for(int i =0; i<array.length; i++ ) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            array[counter] = num;
            counter++;
            sum=sum+num;

            if( num > 0){
                moreZeroSum++;
            }
        }

        System.out.println("Массив: " + Arrays.toString(array));

        boolean isSorted = false;
        while(!isSorted){

            isSorted = true;

            for(int j = 1; j<array.length; j++) {

                if(array[j] < array[j - 1] ){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
        }

        System.out.println("Сумма элементов: " + sum + "\r\n"+
                           "Количество положительных элементов: " + moreZeroSum + "\r\n"+
                           "Отсортированный массив: " + Arrays.toString(array));

    }
}
