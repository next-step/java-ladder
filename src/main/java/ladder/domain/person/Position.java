package ladder.domain.person;

import ladder.domain.ladder.HorizontalLineDirection;

import java.awt.*;
import java.util.Objects;

public class Position {

    private final Point position;

    public Position(int x, int y) {
        this.position = new Point(x, y);
    }

    public int x() {
        return this.position.x;
    }

    public int y() {
        return this.position.y;
    }

    public Position descend(HorizontalLineDirection horizontalLineDirection) {
        return new Position(horizontalLineDirection.move(this.x()), descend());
    }

    private int descend() {
        return this.y() + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return (position.x == position1.position.x) && (position.y == position1.position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
