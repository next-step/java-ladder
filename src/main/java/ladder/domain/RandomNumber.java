package ladder.domain;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_RANGE_NUMBER = 10;

    public int randomNumber() {
        return new Random().nextInt(RANDOM_RANGE_NUMBER);
    }
}
