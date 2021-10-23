package com.pb.gvozdev.hw4;

import java.util.Scanner;

public class CapitalLetter {

    static String toUpperCase(String word){

        String firstLet = word.substring(0,1).toUpperCase();
        String bodyWord = word.substring(1);

        return firstLet+bodyWord;
    }

    public static void main(String[] args) {
        System.out.println("Введите строку: ");


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] words = input.split(" ");

        StringBuilder finalInput = new StringBuilder();
        for (String word : words) {

            String temp = toUpperCase(word);

            finalInput.append(" ").append(temp);
        }
        System.out.println("Строка с заглавными буквами:\n" +finalInput);


    }
}
