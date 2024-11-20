package nextstep.ladder.dto;

import nextstep.ladder.dto.validation.CommaSeparatedResultValidator;
import nextstep.ladder.dto.validation.DuplicationValidation;

public class Names extends CommaSeparatedResult {

    public Names(String value) {
        super(value);
    }

    @Override
    protected CommaSeparatedResultValidator validator() {
        CommaSeparatedResultValidator validator = super.validator();
        validator.add(new DuplicationValidation());
        return validator;
    }

}
