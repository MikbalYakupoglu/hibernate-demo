package org.nakoual.hibernatedemo.dto.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.nakoual.hibernatedemo.entity.enums.ResultStatus;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FailureResult extends Result {

    private List<Cause> causes;

    public FailureResult(List<Cause> causes) {
        super(ResultStatus.FAILURE);
        this.causes = causes;
    }

    public List<Cause> getCauses() {
        if(causes == null) {
            causes = new ArrayList<>();
        }
        return causes;
    }
}
