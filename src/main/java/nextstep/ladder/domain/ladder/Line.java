package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Line {

    private final boolean isExist;

    public Line(boolean isExist) {
        this.isExist = isExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return isExist == line.isExist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isExist);
    }
}
