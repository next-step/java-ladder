package nextstep.ladder.dto.validation;

import java.util.List;

public class MinSizeValidation implements CommaSeparatedResultValidation {

    private static final int MIN_SIZE = 2;

    @Override
    public void valid(List<String> values) {
        validValues(values);
    }

    private void validValues(List<String> names) {
        if (inValidSize(names)) {
            throw createException();
        }
    }

    private static boolean inValidSize(List<String> names) {
        return names.size() < MIN_SIZE;
    }

    private static IllegalArgumentException createException() {
        return new IllegalArgumentException("잘못된 입력입니다.");
    }
}
