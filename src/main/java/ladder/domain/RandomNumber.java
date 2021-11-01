package ladder.domain;

import ladder.enums.Numeric;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_RANGE_NUMBER = Numeric.TEN.number();

    public int randomNumber() {
        return new Random().nextInt(RANDOM_RANGE_NUMBER);
    }
}
