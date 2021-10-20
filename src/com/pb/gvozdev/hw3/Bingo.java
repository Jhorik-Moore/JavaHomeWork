package com.pb.gvozdev.hw3;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {

        Random random = new Random();
        int programNumber = random.nextInt(100); //задаем рандом программой
        System.out.println("Программа загадала число (от 0 до 100). Вы пытаетесь отгадать. Завершить игру досрочно - ввести 'стоп'"+"\r\n" +
                "Введите загаданное число:");

        int counter = 0; //счетчик вводов
        String stop = "стоп"; //стоп-слово


        for(int i =0; i<100; i++) {
            Scanner sc = new Scanner(System.in);
            String yourInput = sc.next();
            counter++; //прибавляем каждый ввод

            if(yourInput.toLowerCase().equals(stop)) {
                System.out.println("Спасибо за игру! Всего доброго!");
                break;
             } else {
                    try {
                            int yourInputInt = Integer.parseInt(yourInput);

                            if (yourInputInt == programNumber) {
                                System.out.println("Поздравляем! Число отгадано" + "\r\n" +
                                        "Количество попыток: " + counter);

                            } else if (yourInputInt > programNumber) {
                                System.out.println("Неверно! Загаданное число меньше введенного");
                            } else {
                                System.out.println("Неверно! Загаданное число больше введенного");
                            }

                        } catch (NumberFormatException e) {

                    System.out.println("Введите число или слово 'стоп'");
                   }


              }

         }

    }
}
