package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.IllegalExecutionResultException;

public class Results {
    private static final int ZERO = 0;

    private final List<String> values;

    public Results(List<String> values, int width) {
        validateResultsSize(values, width);
        this.values = values;
    }

    private void validateResultsSize(List<String> values, int width) {
        if(values.size() != width) {
            throw new IllegalExecutionResultException(values.size());
        }
    }

    public Results(String[] values, int width) {
        this(convertToList(values), width);
    }

    private static List<String> convertToList(String[] values) {
        validateNullAndEmpty(values);

        return Arrays.stream(values)
                .collect(Collectors.toList());
    }

    private static void validateNullAndEmpty(String[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalExecutionResultException(ZERO);
        }
    }

    public List<String> getValues() {
        return values;
    }
}
