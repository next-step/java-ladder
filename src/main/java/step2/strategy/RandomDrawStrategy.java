package step2.strategy;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy{
    private static final Random rand = new Random();
    public static final int MAXIMUM_BOUND = 100;
    public static final int RANDOM_CONDITION = 50;

    @Override
    public boolean draw() {
        return rand.nextInt(MAXIMUM_BOUND) > RANDOM_CONDITION;
    }
}
