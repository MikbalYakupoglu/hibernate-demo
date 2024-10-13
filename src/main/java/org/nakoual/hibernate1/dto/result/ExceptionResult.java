package org.nakoual.hibernate1.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ExceptionResult {

    private String endpoint;
    private String exception;
    private String message;
    private String timestamp;
}
