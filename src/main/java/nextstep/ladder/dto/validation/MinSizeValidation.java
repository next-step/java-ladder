package nextstep.ladder.dto.validation;

import java.util.List;
import nextstep.ladder.domain.validator.MinSizeValidator;

public class MinSizeValidation implements CommaSeparatedResultValidation {

    private static final MinSizeValidator minSizeValidator = new MinSizeValidator();

    @Override
    public void valid(List<String> values) {
        validValues(values);
    }

    private void validValues(List<String> names) {
        minSizeValidator.valid(names.size());
    }
}
