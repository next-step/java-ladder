package ladder.domain.ladder;

import java.util.Objects;

public class Point {

    private final PointPosition position;
    private final PointDirection direction;

    public Point() {
        this(0, new PointDirection());
    }

    public Point(int position, PointDirection direction) {
        this.position = new PointPosition(position);
        this.direction = direction;
    }

    public boolean isRight() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(position, point.position) && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "position=" + position +
                        " " + direction;
    }

}

