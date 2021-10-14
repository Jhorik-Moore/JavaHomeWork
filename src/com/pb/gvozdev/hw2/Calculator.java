package com.pb.gvozdev.hw2;

import java.util.Scanner;

public class Calculator {

    private static Integer resultSet, operand1, operand2;
    private static  String sign;

    public static void main(String[] args) {


        System.out.println("Введите целое число/цифру (operand1):");
        Scanner in = new Scanner(System.in);
        operand1 = in.nextInt();
        System.out.println("Введите целое число/цифру (operand2):");
        operand2 = in.nextInt();
        System.out.println("Введите знак арифметической операции  +/-*");
        sign = in.next();

         switch (sign){
             case("+"):
                 resultSet = operand1+operand2;
                 System.out.println("Ответ: "+resultSet);
                 break;
             case("-"):
                 resultSet = operand1-operand2;
                 System.out.println("Ответ: "+resultSet);
                 break;
             case("/"):
                 if(operand2 ==0){
                     System.out.println("На 0 делить нельзя!");
                 } else {
                     resultSet = operand1 / operand2;
                     System.out.println("Ответ: " + resultSet);
                 }
                 break;
             case("*"):
                 resultSet = operand1*operand2;
                 System.out.println("Ответ: "+resultSet);
                 break;
             default:
                 System.out.println("Калькулятор может только складывать, отнимать, умножать и делить.");
         }




    }
}
