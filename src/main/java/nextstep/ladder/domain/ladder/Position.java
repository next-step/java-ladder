package nextstep.ladder.domain.ladder;

import java.util.Objects;

import static nextstep.ladder.domain.ladder.Direction.*;

public class Position {

    private final Direction direction;

    public Position(Direction direction) {
        this.direction = direction;
    }

    public Direction currentDirection() {
        return direction;
    }

    public static Position createPosition(boolean isLastPosition,
                                           DirectionPredicate predicate,
                                           Position prePosition) {
        if (isLastPosition) {
            return prePosition.last();
        }
        return prePosition.next(predicate);
    }

    public Position next(DirectionPredicate predicate) {
        Direction direction = (this.direction == RIGHT) ? LEFT : generate(predicate);
        return new Position(direction);
    }

    public Position last() {
        Direction direction = (this.direction == RIGHT) ? LEFT : DOWN;
        return new Position(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
