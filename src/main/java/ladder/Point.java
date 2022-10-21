package ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private final Boolean leftLine;
    private final Boolean rightLine;

    public Point(int index, Boolean leftLine, Boolean rightLine) {
        this.index = index;
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    public boolean hasLeftLine() {
        return leftLine != null && leftLine;
    }

    public boolean hasRightLine() {
        return rightLine != null && rightLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(leftLine, point.leftLine) && Objects.equals(rightLine, point.rightLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, leftLine, rightLine);
    }
}
