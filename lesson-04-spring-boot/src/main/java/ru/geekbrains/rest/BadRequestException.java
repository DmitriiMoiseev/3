package ru.geekbrains.rest;

public class BadRequestException extends RuntimeException {

    BadRequestException(String message) {
        super (message);
    }
}
