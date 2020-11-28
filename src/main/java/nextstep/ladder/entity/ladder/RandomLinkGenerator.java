package nextstep.ladder.entity.ladder;

import java.util.Random;

public class RandomLinkGenerator implements LinkGenerator{

    private static final RandomLinkGenerator instance = new RandomLinkGenerator();
    private static final Random random = new Random();
    private static final int BOUND = 2_000_000_000;

    private RandomLinkGenerator() {}

    public static RandomLinkGenerator getInstance() {
        return instance;
    }

    @Override
    public boolean isPossibleToLink() {
        return random.nextInt(BOUND) % 2 == 0;
    }

}
