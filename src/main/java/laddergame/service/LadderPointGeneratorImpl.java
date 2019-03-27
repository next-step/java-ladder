package laddergame.service;

import java.util.Random;

public class LadderPointGeneratorImpl implements LadderPointGenerator {
    private static final LadderPointGenerator instance = new LadderPointGeneratorImpl();
    private static final Random random = new Random();

    public static LadderPointGenerator getInstance() {
        return instance;
    }

    public Boolean generate() {
        return random.nextBoolean();
    }
}