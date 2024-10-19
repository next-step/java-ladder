package nextstep.ladder.domain;

import java.util.Objects;

public class LadderHeight {
    public static final int MINIMUM_HEIGHT = 1;

    private final int value;

    public LadderHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 0 이하일 수 없습니다.");
        }
        this.value = height;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
