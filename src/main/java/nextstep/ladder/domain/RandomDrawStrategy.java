package nextstep.ladder.domain;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy {
    private Random RANDOM = new Random();

    public RandomDrawStrategy(Random RANDOM) {
        this.RANDOM = RANDOM;
    }

    public RandomDrawStrategy() {
    }

    @Override
    public boolean draw(int index, boolean previous) {
        if (index == 0 || previous) {
            return false;
        }

        return RANDOM.nextInt(5) >= 2;
    }
}