package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be greater than or equal to 0");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
