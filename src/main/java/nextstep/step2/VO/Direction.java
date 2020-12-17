package nextstep.step2.VO;

import java.util.function.Function;

public enum Direction {
    LEFT(Position::moveToLeft),
    DOWN(Position::moveToDown),
    RIGHT(Position::moveToRight);

    private final Function<Position, Position> computeNextPosition;

    Direction(Function<Position, Position> computeNextPosition) {
        this.computeNextPosition = computeNextPosition;
    }

    public Position getNextPosition(Position Position) {
        return computeNextPosition.apply(Position);
    }
}
