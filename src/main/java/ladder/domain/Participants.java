package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_UNDER_ONE_VALUE = "두 사람 이상 참여해야 합니다.";
    private final static String SEPARATOR = ",";

    private final List<Participant> value;

    public Participants(final String names) {
        validate(names);
        String[] splited = split(names);
        this.value = IntStream.range(0, splited.length)
            .mapToObj(i -> new Participant(splited[i], i))
            .collect(Collectors.toList());
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private String[] split(final String value) {
        String[] result = value.split(SEPARATOR);

        if (result.length <= 1) {
            throw new IllegalArgumentException(ERROR_UNDER_ONE_VALUE);
        }

        return result;
    }

    public int size() {
        return value.size();
    }

    public List<Participant> getValue() {
        return Collections.unmodifiableList(value);
    }
}
