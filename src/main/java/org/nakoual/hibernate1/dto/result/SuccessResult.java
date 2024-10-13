package org.nakoual.hibernate1.dto.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.nakoual.hibernate1.entity.enums.ResultStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class SuccessResult<T> extends Result {

        private T data;

        public SuccessResult(T data) {
            super(ResultStatus.SUCCESS);
            this.data = data;
        }
}
