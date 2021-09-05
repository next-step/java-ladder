package nextstep.ladders.domain.strategy;

import java.util.Random;

public class DirectionRandomGenerate implements DirectionGenerator {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}