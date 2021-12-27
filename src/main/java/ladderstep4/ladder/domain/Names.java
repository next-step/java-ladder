package ladderstep4.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER = ",";
    private static final String NULL_MESSAGE = "입력이 null일 수 없습니다.";
    private static final String EMPTY_MESSAGE = "입력이 비어있을 수 없습니다.";
    private static final int MIN_LENGTH = 1;

    private final List<Name> value;

    public Names(String names) {
        this(toList(names));
    }

    public Names(List<Name> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        if (names.size() < MIN_LENGTH) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        this.value = names;
    }

    private static List<Name> toList(String names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        return Arrays.stream(names.split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public Name findByIndex(int index) {
        return value.get(index);
    }

    public int count() {
        return value.size();
    }

    public List<Name> getValue() {
        return Collections.unmodifiableList(value);
    }

}
