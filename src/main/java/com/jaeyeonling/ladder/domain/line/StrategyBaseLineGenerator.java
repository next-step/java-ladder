package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.point.Direction;

public class StrategyBaseLineGenerator extends RoleBaseLineGenerator {

    private final PointGenerateStrategy pointGenerateStrategy;

    private StrategyBaseLineGenerator(final PointGenerateStrategy pointGenerateStrategy) {
        this.pointGenerateStrategy = pointGenerateStrategy;
    }

    public static StrategyBaseLineGenerator withStrategy(final PointGenerateStrategy pointGenerateStrategy) {
        return new StrategyBaseLineGenerator(pointGenerateStrategy);
    }

    @Override
    Direction generateFirst() {
        return generate();
    }

    @Override
    Direction generateMiddle(final Direction before) {
        if (before == Direction.RIGHT) {
            return Direction.LEFT;
        }

        return generate();
    }

    @Override
    Direction generateEnd(final Direction before) {
        if (before == Direction.RIGHT) {
            return Direction.LEFT;
        }

        return Direction.STRAIGHT;
    }

    private Direction generate() {
        return pointGenerateStrategy.generate() ? Direction.RIGHT : Direction.STRAIGHT;
    }
}
