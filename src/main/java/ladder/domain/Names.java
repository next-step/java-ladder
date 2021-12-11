package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    private static final String NAMES_DELIMITER = ",";
    private static final String NULL_MESSAGE = "입력이 null일 수 없습니다.";
    private static final String EMPTY_MESSAGE = "입력이 비어있을 수 없습니다.";
    private static final int MIN_NAMES_LENGTH = 1;

    private final List<Name> value;

    public Names(String names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        this.value = Arrays.stream(names.split(NAMES_DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());

        if (this.value.size() < MIN_NAMES_LENGTH) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    public int count() {
        return value.size();
    }

    public List<Name> getValue() {
        return Collections.unmodifiableList(value);
    }

}
