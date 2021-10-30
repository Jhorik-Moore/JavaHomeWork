package com.pb.gvozdev.hw5;

import java.util.Arrays;

/**
 * - ФИО
 * - номер читательского билета
 * - факультет
 * - дата рождения
 * - телефон
 * Имеет перегруженные методы takeBook(), returnBook():
 */
public class Reader {

    private final String FIO;
    private final Integer libCardNumber;
    private final String faculty;
    private final String dateOfBirth;
    private final String phoneNumber;

    public Reader(String FIO, Integer libCardNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.FIO = FIO;
        this.libCardNumber = libCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return FIO+", "+libCardNumber+", "+faculty+", "+
                dateOfBirth+", "+phoneNumber;
    }

    /**
     * - takeBook, который будет принимать количество взятых книг.
     * @param count - количество книг
     * @return - строка результата
     */
    public String takeBook(Integer count){
        return FIO+" взял(а) "+count+" книг(и)";
    }

    /**
     * - takeBook, который будет принимать переменное количество названий книг.
     * @param title - наименования книг
     * @return - строка результата
     */
    public String takeBook(String... title){

        return FIO+" взял(а) книги: "+
                Arrays.toString(title).replaceAll("[^А-Яа-я ё ,]", "");
    }

    /**
     * - takeBook, который будет принимать переменное количество объектов класса Book.
     * @param book - объект класса Book
     * @return - строка результата
     */
    public String takeBook(Object... book){

        return FIO+" взял(а) книги: "+
               Arrays.toString(book).replaceAll("[^А-Яа-я (),.ё 0-9]","");
    }

    /**
     * метод returnBook, который будет принимать количество возвращенных книг
     * @param count - количество книг
     * @return - строка результата
     */
    public String returnBook(Integer count){
        return FIO+" вернул(а) "+count+" книг(и)";
    }
    /**
     * - returnBook, который будет принимать переменное количество названий книг.
     * @param title - наименования книг
     * @return - строка результата
     */
    public String returnBook(String... title){

        return FIO+" вернул(а) книги: "+
                Arrays.toString(title).replaceAll("[^А-Яа-я ё ,]", "");
    }
    /**
     * - returnBook, который будет принимать переменное количество объектов класса Book.
     * @param book - объект класса Book
     * @return - строка результата
     */
    public String returnBook(Object... book){

        return FIO+" вернул(а) книги: "+
                Arrays.toString(book).replaceAll("[^А-Яа-я (),.ё 0-9]","");
    }

}
