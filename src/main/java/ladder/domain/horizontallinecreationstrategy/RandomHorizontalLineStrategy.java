package ladder.domain.horizontallinecreationstrategy;

import java.util.Random;

public class RandomHorizontalLineStrategy implements HorizontalLineStrategy {

    private static final Random random = new Random();

    public RandomHorizontalLineStrategy() {
    }

    @Override
    public boolean isAbleToGenerate() {
        return random.nextBoolean();
    }
}
