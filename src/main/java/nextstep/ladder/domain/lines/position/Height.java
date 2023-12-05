package nextstep.ladder.domain.lines.position;

import java.util.Objects;

public class Height {

    private final int value;

    public Height(int value) {
        this.value = value;
    }

    public boolean isLessThan(int maxHeight) {
        return this.value < maxHeight;
    }

    public Height higherHeight() {
        return new Height(this.value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height height1 = (Height) o;
        return value == height1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Height{" +
                "value=" + value +
                '}';
    }
}
