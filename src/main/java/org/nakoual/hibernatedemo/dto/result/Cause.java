package org.nakoual.hibernatedemo.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cause {

    private String code;
    private String message;
}
