package ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private final boolean leftLine;
    private final boolean rightLine;

    public Point(int index, boolean leftLine, boolean rightLine) {
        this.index = index;
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    public boolean hasLeftLine() {
        return leftLine;
    }

    public boolean hasRightLine() {
        return rightLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && leftLine == point.leftLine && rightLine == point.rightLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, leftLine, rightLine);
    }
}
