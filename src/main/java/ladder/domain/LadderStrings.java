package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderStrings<T extends LadderString> {

    protected static final String DELIMITER = ",";
    protected static final String NULL_MESSAGE = "입력이 null일 수 없습니다.";
    protected static final String EMPTY_MESSAGE = "입력이 비어있을 수 없습니다.";
    protected static final int MIN_LENGTH = 1;

    private final List<T> value;

    public LadderStrings(List<T> ladderStrings) {
        if (Objects.isNull(ladderStrings)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        if (ladderStrings.size() < MIN_LENGTH) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        this.value = ladderStrings;
    }

    public T findByIndex(int index) {
        return value.get(index);
    }

    public int count() {
        return value.size();
    }

    public List<T> getValue() {
        return Collections.unmodifiableList(value);
    }

}
