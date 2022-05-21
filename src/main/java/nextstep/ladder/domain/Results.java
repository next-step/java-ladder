package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String RESULT_NULL_OR_EMPTY_ERROR_MESSAGE = "입력된 실행 결과가 없습니다.";

    private final List<String> values;

    public Results(List<String> values) {
        this.values = values;
    }

    public Results(String[] values) {
        this(convertToList(values));
    }

    private static List<String> convertToList(String[] values) {
        validateNullAndEmpty(values);

        return Arrays.stream(values)
                .collect(Collectors.toList());
    }

    private static void validateNullAndEmpty(String[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(RESULT_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    public List<String> getValues() {
        return values;
    }
}
