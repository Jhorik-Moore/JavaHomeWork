package com.pb.gvozdev.hw8;

public class WrongLoginException extends Exception {

   static private final String e = "-> Wrong Login";

    public WrongLoginException() {
        super(e);
    }
    public WrongLoginException(String message) {
        super(message);
    }

}
