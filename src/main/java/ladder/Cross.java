package ladder;

import java.util.Objects;

public class Cross {
    private final Position position;
    private final Point point;

    public Cross(Position poisition, Point point) {
        this.position = poisition;
        this.point = point;
    }

    public Position move() {
        if (point.move() == Direction.RIGHT) {
            return position.left();
        }
        if (point.move() == Direction.LEFT) {
            return position.right();
        }
        return position;
    }

    public Direction getDirection() {
        return point.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cross cross = (Cross) o;
        return Objects.equals(position, cross.position) && Objects.equals(point, cross.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, point);
    }

}
