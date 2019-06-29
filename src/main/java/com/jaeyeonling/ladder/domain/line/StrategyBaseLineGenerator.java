package com.jaeyeonling.ladder.domain.line;

public class StrategyBaseLineGenerator extends RoleBaseLineGenerator {

    private final PointGenerateStrategy pointGenerateStrategy;

    private StrategyBaseLineGenerator(final PointGenerateStrategy pointGenerateStrategy) {
        this.pointGenerateStrategy = pointGenerateStrategy;
    }

    public static StrategyBaseLineGenerator of(final PointGenerateStrategy pointGenerateStrategy) {
        return new StrategyBaseLineGenerator(pointGenerateStrategy);
    }

    @Override
    Boolean generate(final Boolean before) {
        if (before) {
            return false;
        }

        return pointGenerateStrategy.generate();
    }
}
