package com.jaeyeonling.ladder;

import java.util.ArrayList;
import java.util.List;

public class StrategyBaseLineGenerator implements LineGenerator {

    private final PointGenerateStrategy pointGenerateStrategy;

    private StrategyBaseLineGenerator(final PointGenerateStrategy pointGenerateStrategy) {
        this.pointGenerateStrategy = pointGenerateStrategy;
    }

    public static StrategyBaseLineGenerator of(final PointGenerateStrategy pointGenerateStrategy) {
        return new StrategyBaseLineGenerator(pointGenerateStrategy);
    }

    @Override
    public Line generate(final CountOfUsers countOfUsers) {
        final List<Boolean> points = generatePoints(countOfUsers);

        return Line.of(points);
    }

    private List<Boolean> generatePoints(final CountOfUsers countOfUsers) {
        final List<Boolean> points = initializePoints();
        for (int i = points.size(); i < countOfUsers.getValue(); i++) {
            generate(points);
        }

        return points;
    }

    private List<Boolean> initializePoints() {
        final List<Boolean> points = new ArrayList<>();

        points.add(false);

        return points;
    }

    private void generate(List<Boolean> points) {
        final Boolean before = points.get(points.size() - 1);
        if (before) {
            points.add(false);
            return;
        }

        points.add(pointGenerateStrategy.generate());
    }
}
