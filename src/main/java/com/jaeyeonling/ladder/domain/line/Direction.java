package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Index;

import java.util.function.UnaryOperator;

public enum Direction {

    LEFT(Index::decrement),
    RIGHT(Index::increment),
    STRAIGHT(UnaryOperator.identity());

    private final UnaryOperator<Index> moveFunction;

    Direction(final UnaryOperator<Index> moveFunction) {
        this.moveFunction = moveFunction;
    }

    public static Direction first(final DirectionGenerateStrategy strategy) {
        return generate(strategy);
    }

    private static Direction generate(final DirectionGenerateStrategy strategy) {
        return strategy.generate() ? RIGHT : STRAIGHT;
    }

    public Direction next(final DirectionGenerateStrategy strategy) {
        return this == RIGHT ? LEFT : generate(strategy);
    }

    public Direction last() {
        return this == RIGHT ? LEFT : STRAIGHT;
    }

    public Index move(final Index index) {
        return moveFunction.apply(index);
    }
}
