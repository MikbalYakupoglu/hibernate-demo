package org.nakoual.hibernatedemo.dto.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.nakoual.hibernatedemo.entity.enums.ResultStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class SuccessResult<T> extends Result {

        private T data;

        public SuccessResult(T data) {
            super(ResultStatus.SUCCESS);
            this.data = data;
        }
}
