package ladder.domain;

import java.util.Random;

public class RandomNumber {

    private static final int MAKE_LADDER_NUMBER = 4;
    private static final int RANDOM_RANGE_NUMBER = 10;


    public boolean makableLadder(int number) {
        return number > MAKE_LADDER_NUMBER;
    }

    public int randomNumber() {
        return new Random().nextInt(RANDOM_RANGE_NUMBER);
    }
}
