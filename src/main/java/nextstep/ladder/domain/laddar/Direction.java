package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.player.Position;
import nextstep.ladder.domain.strategy.DirectionStrategy;

import java.util.Objects;
import java.util.function.Function;

public enum Direction {
    LEFT(Position::moveLeft),
    RIGHT(Position::moveRight),
    SOUTH(nonMove -> nonMove);

    private final Function<Position, Position> moveFunction;

    Direction(Function<Position, Position> moveFunction) {
        this.moveFunction = moveFunction;
    }

    public static Direction createFirst(final DirectionStrategy generator) {
        return Objects.requireNonNull(generator).isPossible() ? RIGHT : SOUTH;
    }

    public Direction createNext(final DirectionStrategy generator) {
        return isRight() ? LEFT : createFirst(generator);
    }

    public Direction createLast() {
        return isRight() ? LEFT : SOUTH;
    }

    public Position move(Position position) {
        return moveFunction.apply(position);
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
