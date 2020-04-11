package nextstep.ladder.domain.line;

import java.util.Random;

public class RandomDirectionSelector implements DirectionSelector {
    private static final int RANGE = 10;
    private static final int PROBABILITY = 7;

    private Random random;

    public RandomDirectionSelector() {
        this.random = new Random();
    }

    @Override
    public boolean hasRightDirection() {
        return random.nextInt(RANGE) < PROBABILITY;
    }
}
