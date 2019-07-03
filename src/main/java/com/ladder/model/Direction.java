package com.ladder.model;

import java.util.function.Function;

public enum Direction {

    LEFT(false, Position::moveBackward),
    RIGHT(true, Position::moveForward),
    DOWN(false, position -> position);

    private boolean isRight;
    private Function<Position, Position> movable;

    Direction(boolean isRight, Function<Position, Position> movable) {
        this.isRight = isRight;
        this.movable = movable;
    }

    public boolean isRight() {
        return isRight;
    }

    public Position move(Position currentPosition) {
        return movable.apply(currentPosition);
    }
}
