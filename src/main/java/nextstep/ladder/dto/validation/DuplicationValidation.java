package nextstep.ladder.dto.validation;

import java.util.List;

public class DuplicationValidation implements CommaSeparatedResultValidation {
    @Override
    public void valid(List<String> values) {
        if (hasDuplication(values)) {
            throw createException();
        }
    }

    private boolean hasDuplication(List<String> result) {
        return distinctCount(result) != result.size();
    }

    private static long distinctCount(List<String> result) {
        return result.stream().distinct().count();
    }

    private static IllegalArgumentException createException() {
        return new IllegalArgumentException("잘못된 입력입니다.");
    }
}
