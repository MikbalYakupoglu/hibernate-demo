package org.nakoual.hibernatedemo.dto.result;

import lombok.Data;
import org.nakoual.hibernatedemo.entity.enums.ResultStatus;

@Data
public abstract class Result {

    private ResultStatus status;

    protected Result() {
    }

    protected Result(ResultStatus status) {
        this.status = status;
    }

}
