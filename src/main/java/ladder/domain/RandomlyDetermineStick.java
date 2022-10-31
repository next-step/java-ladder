package ladder.domain;

import java.util.Random;

public class RandomlyDetermineStick implements DetermineStick {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int CONDITION = 4;

    @Override
    public boolean isExists() {
        return RANDOM.nextInt(BOUND) > CONDITION;
    }
}
