package ladder.domain;

import java.util.Objects;
import ladder.domain.ladder.HorizontalLineDirection;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public Position descend(HorizontalLineDirection horizontalLineDirection) {
        if (horizontalLineDirection.isRight()) {
            return moveLeft();
        }
        if (horizontalLineDirection.isLeft()) {
            return moveRight();
        }
        return moveStraight();
    }

    private Position moveLeft() {
        return new Position(this.x + 1, this.y + 1);
    }

    private Position moveRight() {
        return new Position(this.x - 1, this.y + 1);
    }

    private Position moveStraight() {
        return new Position(this.x, this.y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
