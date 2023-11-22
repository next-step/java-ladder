package nextstep.ladder.domain.wrapper;

import java.util.Objects;

public class Width {

    private int position;

    public Width(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Width width = (Width) o;
        return position == width.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
