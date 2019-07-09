package com.jaeyeonling.ladder2.domain.line;

import com.jaeyeonling.ladder2.domain.Index;
import com.jaeyeonling.ladder2.domain.user.Username;
import com.jaeyeonling.ladder2.view.StringVisualizable;

import java.util.function.UnaryOperator;

public enum Direction implements StringVisualizable {

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

    @Override
    public String visualize() {
        final String replaceCharacter = this == LEFT ? "-" : " ";
        return replaceCharacter.repeat(Username.MAX_LENGTH) + "|";
    }
}
