package nextstep.ladder.domain.strategy;

import java.util.Random;

public class RandomCreateStrategy implements CreateStrategy {

    private boolean beforeExist;

    public RandomCreateStrategy() {
        this.beforeExist = false;
    }

    @Override
    public boolean isCreate(boolean beforeExist) {
        boolean isCraete = false;

        if (new Random().nextBoolean() && isBeforeNotExist(beforeExist)) {
            isCraete = true;
        }

        this.beforeExist = beforeExist;
        return isCraete;
    }

    private static boolean isBeforeNotExist(final boolean beforeExist) {
        return !beforeExist;
    }
}
