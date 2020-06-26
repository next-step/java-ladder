package nextstep.ladder.generator;

import java.util.Random;

public class RandomPointGenerator implements LadderPointGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generatePoint() {
        return random.nextBoolean();
    }
}
