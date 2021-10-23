package com.pb.gvozdev.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    static String sortString(String str){

        String[] arrayString = str.split("");
        Arrays.sort(arrayString);

        return Arrays.toString(arrayString);
    }

    public static void main(String[] args){

        System.out.println("Введите строку №1: ");

            Scanner scanner = new Scanner(System.in);
            String str1 = scanner.nextLine();

            String strLet1 = str1.toLowerCase().replaceAll("[^a-zа-я]", "");
            String sort1 = sortString(strLet1);


        System.out.println("Введите строку №2: ");

            String str2 = scanner.nextLine();

            String strLet2 = str2.toLowerCase().replaceAll("[^a-zа-я]", "");
            String sort2 = sortString(strLet2);


            if(sort1.equals(sort2)){
                System.out.println("Строка 1 является анаграммой строки 2");
            } else System.out.println("Анограмма отсутствует");



    }
}
