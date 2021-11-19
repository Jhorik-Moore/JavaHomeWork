package com.pb.gvozdev.hw8;

public class OnlineShop {

    public static void main(String[] args) {

        Auth user = new Auth();

        System.out.println("Регистрация пользователя...");
        try {

            user.signUp("login", "password123", "password123");
            System.out.println("Регистрация успешна");

            System.out.println("Вход пользователя...");
            try {
                user.sigIn("log", "pass");
                System.out.println("Вход выполнен!");

            } catch (WrongLoginException e){
                System.out.println("Неверный логин/пароль");
            }

        } catch (WrongPasswordException | WrongLoginException e){
            System.out.println(e.getMessage());
        }


    }


}
