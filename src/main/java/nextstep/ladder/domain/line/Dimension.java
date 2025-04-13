package nextstep.ladder.domain.line;

import java.util.Objects;

public class Dimension {
    private final int value;

    public Dimension(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("치수는 1 이상이여야 합니다.");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimension dimension = (Dimension) o;
        return value == dimension.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
