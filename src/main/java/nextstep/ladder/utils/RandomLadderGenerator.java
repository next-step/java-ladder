package nextstep.ladder.utils;

import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }

}
