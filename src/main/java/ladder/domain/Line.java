package ladder.domain;

import java.util.Objects;

public class Line {

    private Boolean isLine;

    public Line(Boolean isLine) {
        this.isLine = isLine;
    }

    public static Line of(Boolean isLine) {
        return new Line(isLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(isLine, line.isLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLine);
    }

    public Boolean getLine() {
        return isLine;
    }
}
