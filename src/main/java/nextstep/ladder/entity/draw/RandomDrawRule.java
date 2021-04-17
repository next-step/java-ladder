package nextstep.ladder.entity.draw;

import java.util.Random;

public class RandomDrawRule implements DrawRule {
    private static final Random random = new Random();

    @Override
    public boolean drawRule() {
        return random.nextBoolean();
    }
}
