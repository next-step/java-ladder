package nextstep.ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private final int value;

    public LadderHeight(int height) {
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
