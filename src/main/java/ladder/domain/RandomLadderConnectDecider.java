package ladder.domain;

import java.util.Random;

public class RandomLadderConnectDecider implements LadderConnectDecider {
    private final Random random = new Random();

    @Override
    public boolean decide() {
        return random.nextBoolean();
    }
}
