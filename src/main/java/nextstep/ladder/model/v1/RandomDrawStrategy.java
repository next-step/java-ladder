package nextstep.ladder.model.v1;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy {
    private static final Random random = new Random();

    @Override
    public boolean draw() {
        return random.nextBoolean();
    }
}
