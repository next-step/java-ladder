package nextstep.ladder.domain;

import java.util.Random;

public class RandomGenerableStrategy implements GenerableStrategy {

    private Random random;

    public RandomGenerableStrategy() {
        random = new Random();
    }

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
