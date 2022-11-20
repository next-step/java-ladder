package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Direction direction(){
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
