package ladder.domain.Ladder;

import ladder.domain.participants.Position;

import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(Position::moveLeft),
    RIGHT(Position::moveRight),
    BYPASS(Position::byPass);

    private final UnaryOperator<Position> directionFunc;

    Direction(UnaryOperator<Position> directionFunc) {
        this.directionFunc = directionFunc;
    }

    public Position move(Position position) {
        return directionFunc.apply(position);
    }
}
