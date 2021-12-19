package nextstep.ladder.model;

import java.util.Objects;

public class Index {
    private static final String MESSAGE_INDEX_CAN_ONLY_POSITIVE = "INDEX는 0 이하의 값이 들어올 수 없습니다.";

    public static final int ZERO = 0;
    public static final int ONE = 1;

    private final int index;

    public Index() {
        this(ZERO);
    }

    public Index(int index) {
        this.index = validationNegative(index);
    }

    public Index next() {
        return new Index(this.index + 1);
    }

    public Index prev() {
        return new Index(this.index - 1);
    }

    private int validationNegative(int index) {
        if (index < 0) {
            throw new IllegalArgumentException(MESSAGE_INDEX_CAN_ONLY_POSITIVE);
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index1 = (Index) o;
        return index == index1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
