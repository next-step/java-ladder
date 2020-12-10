package ladder.domain;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {
    private static final int THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean tryLink() {
        return random.nextInt(THRESHOLD * 2) >= THRESHOLD;
    }
}
