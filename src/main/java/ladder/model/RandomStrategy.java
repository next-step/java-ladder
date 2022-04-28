package ladder.model;

import java.util.Random;

public class RandomStrategy implements GenerationStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }

}
