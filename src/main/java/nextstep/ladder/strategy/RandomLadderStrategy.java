package nextstep.ladder.strategy;

import java.util.Random;

public class RandomLadderStrategy implements LadderStrategy {

    private final Random random;

    public RandomLadderStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean creatable() {
        return random.nextBoolean();
    }
}
