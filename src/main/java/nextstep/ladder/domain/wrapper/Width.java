package nextstep.ladder.domain.wrapper;

import java.util.Objects;

public class Width {

    private int value;

    public Width(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Width width = (Width) o;
        return value == width.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
