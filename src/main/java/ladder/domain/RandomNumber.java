package ladder.domain;

import java.util.Random;

public class RandomNumber {

    private static final int makableLadderNumber = 4;


    public boolean makableLadder(int number) {
        return number > makableLadderNumber;
    }

    public int randomNumber() {
        return new Random().nextInt(10);
    }
}
