package ladder.domain.participants;

import ladder.domain.ladders.ladder.Point;

import java.util.List;
import java.util.Objects;

public class Position {

    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public Position moveLeft() {
        return new Position(index - 1);
    }

    public Position moveRight() {
        return new Position(index + 1);
    }

    public Position byPass() {
        return this;
    }

    public Point find(List<Point> points) {
        return points.get(this.index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return index == position.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
