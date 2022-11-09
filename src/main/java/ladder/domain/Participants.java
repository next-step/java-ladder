package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_UNDER_ONE_VALUE = "두 사람 이상 참여해야 합니다.";
    private final static String SEPARATOR = ",";

    private final List<Name> names;

    public Participants(final String names) {
        validate(names);
        this.names = split(names);
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private List<Name> split(final String value) {
        List<Name> result = Arrays.stream(value.split(SEPARATOR))
            .map(Name::new)
            .collect(Collectors.toList());

        if (result.size() <= 1) {
            throw new IllegalArgumentException(ERROR_UNDER_ONE_VALUE);
        }

        return result;
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
