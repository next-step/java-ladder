package ladder.domain;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {
    private final Random random = new Random();

    @Override
    public boolean tryLink() {
        return random.nextBoolean();
    }
}
