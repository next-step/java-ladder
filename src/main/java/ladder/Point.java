package ladder;

import java.util.Objects;

public class Point {
    private final Position position;
    private final PointElement element;

    public Point(int position, PointElement element) {
        this(Position.of(position), element);
    }

    public Point(Position position, PointElement element) {
        this.position = position;
        this.element = element;
    }

    public Point nextPoint(boolean nextValue) {
        return new Point(position.movedPosition(Position.of(1)), element.nextElement(nextValue));
    }

    public Position nextLinePosition() {
        return element.move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && element == point.element;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, element);
    }
}
