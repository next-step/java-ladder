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
        if (moveHorizontalDirection.isRight()) {
            return moveLeft();
        }
        if (moveHorizontalDirection.isLeft()) {
            return moveRight();
        }
        return moveStraight();
    }

    private Position moveLeft() {
        return new Position(this.x() + 1, this.y() + 1);
    }

    private Position moveRight() {
        return new Position(this.x() - 1, this.y() + 1);
    }

    private Position moveStraight() {
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
        return (position.x == position1.x()) && (position.y == position1.y());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
