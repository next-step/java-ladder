package nextstep.step2.domain;

import java.util.Random;

public class RandomPointCreationStrategy implements PointCreationStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean isCreation() {
        return RANDOM.nextBoolean();
    }
}
