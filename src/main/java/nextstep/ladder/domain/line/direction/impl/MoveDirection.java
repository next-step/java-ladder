package nextstep.ladder.domain.line.direction.impl;

import nextstep.ladder.domain.line.direction.Direction;

public enum MoveDirection implements Direction {
    NO_MOVE(0),
    LEFT(-1),
    RIGHT(1);

    private final int value;

    MoveDirection(int value) {
        this.value = value;
    }

    @Override
    public int move(int currentIndex){
        return value + currentIndex;
    }
}
