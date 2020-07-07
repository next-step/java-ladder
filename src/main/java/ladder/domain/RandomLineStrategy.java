package ladder.domain;

import java.util.Random;

public class RandomLineStrategy implements HorizontalLineStrategy{
    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public boolean isDrawLine() {
        return RANDOM_GENERATOR.nextBoolean();
    }
}
