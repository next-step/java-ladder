package nextstep.ladder.domain;

import java.util.Random;

public class RandomBarGeneratorStrategy implements BarGeneratorStrategy {
    private static final RandomBarGeneratorStrategy instance = new RandomBarGeneratorStrategy();
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 1;

    private RandomBarGeneratorStrategy() {
    }

    public static RandomBarGeneratorStrategy getInstance() {
        return instance;
    }

    @Override
    public boolean generable() {
        int randomNumber = RANDOM.nextInt(MAX_NUMBER + 1);
        return randomNumber == MAX_NUMBER;
    }
}
