package com.pb.gvozdev.hw11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class Contacts {

    private static final List<Element> list = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Contacts.class.getName());
    private static final Path path = Paths.get("src/com/pb/gvozdev/hw11/files/writeContacts.txt");

    public static void listCheck() {
        if (list.isEmpty())
            System.out.println("Телефонная книга пуста...");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("""
                ==== Телефонная книга ====
                Функции:\s
                1.добавление элемента
                2.удаление элемента
                3.поиск элементов
                4.вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
                5.редактирование элемента
                6.запись в файл всех данных
                7.загрузка из файла всех данных
                """);

        for (int i = 0; i < 20; i++) {
            System.out.println("Введите в консоли номер пункта выполнения функции:");
            Scanner scanner = new Scanner(System.in);
            int methodNum = scanner.nextInt();

            if (methodNum == 1) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите ФИО контакта:");
                String fullName = scan.nextLine();

                System.out.println("Введите дату рождения контакта:");
                String dateOfBirth = scan.nextLine();

                System.out.println("Введите номер телефона контакта (380***):");
                String phone = scan.nextLine();

                System.out.println("Введите адресс контакта:");
                String adress = scan.nextLine();

                String dateTimeMod = new Date().toString();

                Element elements = new Element(fullName, dateOfBirth, phone, adress, dateTimeMod);

                list.add(elements);
            }
            if (methodNum == 2) {
                System.out.println("Укажите номер телефона контакта, который нужно удалить:");
                Scanner scan = new Scanner(System.in);
                String phone = scan.nextLine();

                list.removeIf(ob -> ob.getPhone().equals(phone));
                System.out.println("Контакт успешно удален");
            }
            if (methodNum == 3) {
                System.out.println("Введите номер телефона для поиска контакта:");
                Scanner scan = new Scanner(System.in);
                String phone = scan.nextLine();
                list.stream().filter(j ->
                        j.getPhone().equals(phone)).forEach(el -> {
                    try {
                        Converter.toJSON(el);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (methodNum == 4) {
                System.out.println("Введите номер пункта для выбора сортировки записей:"
                        + "\n1.По ФИО"
                        + "\n2.По времени добавления(сначала новые)");
                int s = scanner.nextInt();

                if (s == 1) {
                    listCheck();
                    list.sort(Comparator.comparing(Element::getFullName));
                    list.forEach(el -> {
                        try {
                            Converter.toJSON(el);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (s == 2) {
                    listCheck();
                    list.sort(Comparator.comparing(Element::getDateTimeMod));
                    list.forEach(el -> {
                        try {
                            Converter.toJSON(el);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
            if (methodNum == 5) {
                System.out.println("Введите номер телефона контакта, который нужно редактировать:");
                Scanner scan = new Scanner(System.in);
                String tel = scan.nextLine();
                System.out.println("Введите новое ФИО контакта:");
                String fullName = scan.nextLine();

                System.out.println("Введите новую дату рождения контакта:");
                String dateOfBirth = scan.nextLine();

                System.out.println("Введите номер телефона контакта (380***):");
                String phone = scan.nextLine();

                System.out.println("Введите адресс контакта:");
                String adress = scan.nextLine();

                String dateTimeMod = new Date().toString();

                list.stream().filter(el -> el.getPhone().equals(tel)).forEach(el -> {
                    el.setFullName(fullName);
                    el.setDateOfBirth(dateOfBirth);
                    el.setPhone(phone);
                    el.setAdress(adress);
                    el.setDateTimeMod(dateTimeMod);
                });
                System.out.println("Контакт успешно изменен!");
            }
            if (methodNum == 6) {
                try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                    for (Element el : list) {
                       Object obj = Converter.toJSONwrite(el);
                        writer.write(obj.toString());
                        writer.newLine();
                    }
                    logger.info("- Write in file " + path.toAbsolutePath() +
                            " successfully!");
                } catch (Exception e) {
                    logger.severe("!!!Failed to write in file..\nDescription: " +
                            e.getMessage());
                }
            }
            if (methodNum == 7) {
                String file = "src/com/pb/gvozdev/hw11/files/writeContacts.txt";
                Files.lines(Paths.get(file)).forEach(System.out::println);
            }
        }
    }
}




