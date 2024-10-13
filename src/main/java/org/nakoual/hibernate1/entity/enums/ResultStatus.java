package org.nakoual.hibernate1.entity.enums;

import lombok.Getter;

@Getter
public enum ResultStatus {

    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");


    private final String status;

    ResultStatus(String status) {
        this.status = status;
    }

}
