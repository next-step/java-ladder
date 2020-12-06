package ladder.domain;

import java.util.Objects;

public class Line {

    private final boolean isLine;

    private Line(boolean isNextLine) {
        this.isLine = isNextLine;
    }

    public static Line of(boolean isLine) {
        return new Line(isLine);
    }

    public boolean getLine() {
        return this.isLine;
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
}
