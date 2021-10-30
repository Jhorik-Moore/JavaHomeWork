package com.pb.gvozdev.hw5;

/**
 * - печатаются все книги.
 * - печатаются все читатели.
 * - демонстрируется работа всех вариантов методов takeBook() и returnBook().
 */
public class Library {

    public static void main(String[] args) {

        Book book1 = new Book("Преступление и наказание","Ф. М. Достоевский","1866г.");
        Book book2 = new Book("Мёртвые души","Н. В. Гоголь","1842г.");
        Book book3 = new Book("Война и Мир","Л. Н. Толстой","1865г.");
        Book book4 = new Book("Недоросль","Д. И. Фонвизин","1783г.");
        Book book5 = new Book("Ревизор","Н. В. Гоголь","1836г.");
        Book book6 = new Book("Идиот","Ф. М. Достоевский","1868г.");

        Reader reader1 = new Reader("Анатольев А.А.",340809,"Транспортных технологий","09.08.1991","380667894321");
        Reader reader2 = new Reader("Семенова А.Б.",340700,"Экономический","09.08.1990","380737894321");
        Reader reader3 = new Reader("Сидоров А.В.",340601,"Менеджмент","09.08.1992","380507894321");
        Reader reader4 = new Reader("Иванов А.Г.",350303,"Инженерный","09.08.1993","380907894321");
        Reader reader5 = new Reader("Саян А.Д.",324801,"Геодезии","09.08.1989","380697894321");
        Reader reader6 = new Reader("Шпак А.Е.",346608,"Юридический","09.08.1988","380637894321");

        Object[] books = {book1,book2,book3,book4,book5,book6};
        Object[] readers = {reader1,reader2,reader3,reader4,reader5,reader6};

        System.out.println("КНИГИ:"+"\n");
        for(Object book : books ){
            System.out.println(book.toString());
        }

        System.out.println("\n"+"ЧИТАТЕЛИ:"+"\n");
        for(Object reader : readers ){
            System.out.println(reader.toString());
        }

        System.out.println("\n"+"МЕТОДЫ -takeBook():"+"\n");

        System.out.println(reader3.takeBook(3));
        System.out.println(reader1.takeBook("Преступление и наказание", "Война и Мир", "Ревизор"));
        System.out.println(reader5.takeBook(book1,book4,book3));

        System.out.println("\n"+"МЕТОДЫ -returnBook():"+"\n");

        System.out.println(reader6.returnBook(3));
        System.out.println(reader4.returnBook("Мёртвые души", "Недоросль", "Идиот"));
        System.out.println(reader2.returnBook(book6,book2,book5));


    }
}
