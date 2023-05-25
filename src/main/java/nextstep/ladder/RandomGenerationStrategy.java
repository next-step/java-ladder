package nextstep.ladder;

import java.util.Random;

public class RandomGenerationStrategy implements GenerationStrategy {
    private final Random random = new Random();
    @Override
    public boolean shouldPlace() {
        return random.nextBoolean();
    }
}
