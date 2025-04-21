package nextstep.ladder.strategy;

import nextstep.ladder.generator.RandomGenerator;

public class RandomStrategy implements LineStrategy{
    final RandomGenerator randomGenerator;

    public RandomStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isDraw() {
        return randomGenerator.generate();
    }
}
