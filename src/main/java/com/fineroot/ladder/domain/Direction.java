package com.fineroot.ladder.domain;

import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(Position::decrease),
    RIGHT(Position::increase),
    PASS(e->e);

    private final UnaryOperator<Position> movement;

    Direction(UnaryOperator<Position> movement) {
        this.movement = movement;
    }

    public UnaryOperator<Position> getMovement() {
        return movement;
    }
}
