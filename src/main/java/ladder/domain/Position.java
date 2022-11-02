package ladder.domain;

import java.awt.*;
import java.util.Objects;
import ladder.domain.ladder.direction.MoveHorizontalDirection;

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

    public Position descend(MoveHorizontalDirection moveHorizontalDirection) {
        if (moveHorizontalDirection.isCurrentRight()) {
            return new Position(this.x() + 1, this.y() + 1);
        }
        if (moveHorizontalDirection.isCurrentLeft()) {
            return new Position(this.x() - 1, this.y() + 1);
        }
        return new Position(this.x(), this.y() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return (position.x == position1.position.x) && (position.y == position1.position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
