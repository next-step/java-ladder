package nextstep.ladder.model;

import java.util.Random;

public class RandomLineDrawStrategy implements LineDrawStrategy {
    private final Random random = new Random();

    @Override
    public boolean decideToDraw() {
        return random.nextBoolean();
    }
}
