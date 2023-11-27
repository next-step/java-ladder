package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Point;

import java.util.Random;

public class RandomCreateStrategy implements CreateStrategy {
    public RandomCreateStrategy() {
    }

    @Override
    public boolean isCreate(Point point) {
        return new Random().nextBoolean() && isBeforeFalse(point);
    }

    private static boolean isBeforeFalse(final Point point) {
        return !point.current();
    }

    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }
}
