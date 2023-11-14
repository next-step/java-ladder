package nextstep.ladder.domain.strategy;

import java.util.Random;

public class RandomLinePointGenerateStrategy implements LinePointGenerateStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean isGenerate() {
        return RANDOM.nextBoolean();
    }
}
