package nextstep.ladder.domain;

import java.util.Random;

public class RandomBarGeneratorStrategy implements BarGeneratorStrategy {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 1;

    @Override
    public boolean generable() {
        int randomNumber = RANDOM.nextInt(MAX_NUMBER + 1);
        return randomNumber == MAX_NUMBER;
    }
}
