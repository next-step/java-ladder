package ladder.domain;

import java.util.Objects;

public class Line {

    private final Width width;

    private Line(Width width) {
        this.width = width;
    }

    public static Line createWithWidth(Width width) {
        return new Line(width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(width, line.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
