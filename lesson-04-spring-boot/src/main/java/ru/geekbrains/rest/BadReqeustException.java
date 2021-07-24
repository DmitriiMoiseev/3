package ru.geekbrains.rest;

public class BadReqeustException extends RuntimeException {

    BadReqeustException(String message) {
        super (message);
    }
}
