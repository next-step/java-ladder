package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Position;
import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(Position::decrease),
    RIGHT(Position::increase),
    PASS(e->e);

    private final UnaryOperator<Position> movement;

    Direction(UnaryOperator<Position> movement) {
        this.movement = movement;
    }

    public Position move(Position position) {
        return movement.apply(position);
    }
}
