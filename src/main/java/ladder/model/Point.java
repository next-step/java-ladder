package ladder.model;

import java.util.Objects;

public class Point {
    private int position;
    private Arrow arrow;

    private Point(int position, Arrow arrow) {
        if (position < 0 || (position == 0 && arrow == Arrow.LEFT)) {
            throw new IllegalArgumentException();
        }

        this.position = position;
        this.arrow = arrow;
    }

    public static Point from(int position, Arrow arrow) {
        return new Point(position, arrow);
    }

    public boolean isCollapse(Point target) {
        return arrow == Arrow.RIGHT && this.equals(target);
    }

    public int nextPosition() {
        return arrow.move(position);
    }

    public boolean isRight() {
        return arrow == Arrow.RIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return arrow == point.arrow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrow);
    }
}
