package ladder.domain;

import java.util.Random;

public class RandomLinkable implements Linkable {
    private static final Random random = new Random();

    @Override
    public boolean get() {
        return random.nextBoolean();
    }
}
