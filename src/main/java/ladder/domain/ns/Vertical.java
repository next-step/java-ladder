package ladder.domain.ns;

import ladder.exception.VerticalException;

import java.util.Objects;

public class Vertical {
    public static final String VERTICAL_IS_LESS_THEN_ZERO = "사다리 높이는 0보다 작을수 없습니다.";
    public static final int START = 0;
    private final int value;

    public Vertical(int value) {
        if (value < 0) {
            throw new VerticalException(VERTICAL_IS_LESS_THEN_ZERO);
        }
        this.value = value;
    }

    public Vertical() {
        this(START);
    }

    public Vertical move() {
        return new Vertical(this.value + 1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertical vertical = (Vertical) o;
        return value == vertical.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
