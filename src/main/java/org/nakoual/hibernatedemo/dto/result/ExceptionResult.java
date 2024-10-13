package org.nakoual.hibernatedemo.dto.result;

import lombok.Data;

@Data
public class ExceptionResult {

    private String endpoint;
    private String exception;
    private String message;
    private String timestamp;
}
