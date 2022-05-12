package ladder.domain.step.strategy;

import utils.RandomUtils;

public class RandomCrossStrategy implements CrossStrategy {
    private static int CROSSABLE_POINT = 1;

    private final boolean crossable;

    public boolean isCrossable() {
        return crossable;
    }

    public RandomCrossStrategy() {
        this.crossable = RandomUtils.getRandomPositiveInt(CROSSABLE_POINT) == CROSSABLE_POINT;
    }
}
