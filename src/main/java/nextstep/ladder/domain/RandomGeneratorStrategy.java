package nextstep.ladder.domain;

import java.util.Random;

public class RandomGeneratorStrategy implements GeneratorStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isGenerate() {
        return random.nextBoolean();
    }
}
