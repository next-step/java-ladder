package ladder.domain;

import java.util.Objects;

public class Vertical {

    public static final int START = 0;
    private final int value;

    public Vertical(int value) {
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
