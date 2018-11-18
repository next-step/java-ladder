package ladder.domain;

import java.util.Objects;

public class Point {
    private boolean widthLine;

    private Point(boolean widthLine) {
        this.widthLine = widthLine;
    }

    public static Point of(boolean widthLine) {
        return new Point(widthLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return widthLine == point.widthLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthLine);
    }

    public boolean hasaWidthLine() {
        return widthLine == true;
    }
}
