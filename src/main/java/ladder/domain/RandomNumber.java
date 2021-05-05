package ladder.domain;

import java.util.Random;

public class RandomNumber {

    private static final int MAKABLE_LADDER_NUMBER = 4;


    public boolean makableLadder(int number) {
        return number > MAKABLE_LADDER_NUMBER;
    }

    public int randomNumber() {
        return new Random().nextInt(10);
    }
}
