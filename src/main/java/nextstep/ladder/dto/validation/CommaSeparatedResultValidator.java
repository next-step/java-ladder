package nextstep.ladder.dto.validation;

import java.util.ArrayList;
import java.util.List;

public class CommaSeparatedResultValidator {
    private final List<CommaSeparatedResultValidation> validations;

    public CommaSeparatedResultValidator() {
        this(List.of(new MinSizeValidation()));
    }

    private CommaSeparatedResultValidator(List<CommaSeparatedResultValidation> validations) {
        this.validations = new ArrayList<>(validations);
    }

    public void add(CommaSeparatedResultValidation validation) {
        this.validations.add(validation);
    }

    public void valid(List<String> values) {
        for (CommaSeparatedResultValidation validation : validations) {
            validation.valid(values);
        }
    }
}
