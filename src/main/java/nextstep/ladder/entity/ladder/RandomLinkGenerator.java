package nextstep.ladder.entity.ladder;

import java.util.Random;

public class RandomLinkGenerator implements LinkGenerator{

    private static final RandomLinkGenerator instance = new RandomLinkGenerator();
    private static final Random random = new Random();

    private RandomLinkGenerator() {}

    public static RandomLinkGenerator getInstance() {
        return instance;
    }

    @Override
    public boolean isPossibleToLink() {
        return random.nextBoolean();
    }

}
