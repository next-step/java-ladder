package nextstep.ladder.domain.ladder.line;

import java.util.Objects;

public class HorizontalLine {

    private final int index;

    public HorizontalLine(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HorizontalLine)) return false;
        HorizontalLine that = (HorizontalLine) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
