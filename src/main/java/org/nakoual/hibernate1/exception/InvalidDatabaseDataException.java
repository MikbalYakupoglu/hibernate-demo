package org.nakoual.hibernate1.exception;

public class InvalidDatabaseDataException extends RuntimeException {
    public InvalidDatabaseDataException(String message) {
        super(message);
    }
}
