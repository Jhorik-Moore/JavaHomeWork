package com.pb.gvozdev.hw8;

public class WrongPasswordException extends Exception {

    static private final String message = "-> Wrong {Password}";

    public WrongPasswordException() {
        super(message);
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
