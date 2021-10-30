package com.pb.gvozdev.hw5;

/**
 * - название
 * - автор книги
 * - год издания
 */
public class Book {

    private final String title;
    private final String author;
    private final String yearPublication;


    public Book(String title, String author, String yearPublication) {
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
    }

    @Override
    public String toString() {
        return title+" ("+author+", "+yearPublication+")";
    }
}
