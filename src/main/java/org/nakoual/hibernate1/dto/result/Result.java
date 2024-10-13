package org.nakoual.hibernate1.dto.result;

import lombok.Data;
import org.nakoual.hibernate1.entity.enums.ResultStatus;

@Data
public abstract class Result {

    private ResultStatus status;

    protected Result() {
    }

    protected Result(ResultStatus status) {
        this.status = status;
    }

}
