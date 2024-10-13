package org.nakoual.hibernatedemo.exception;

public class InvalidDatabaseDataException extends RuntimeException {
    public InvalidDatabaseDataException(String message) {
        super(message);
    }
}
