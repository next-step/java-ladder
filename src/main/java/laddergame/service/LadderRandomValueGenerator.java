package laddergame.service;

import java.util.Random;

public class LadderRandomValueGenerator implements LadderValueGenerator {
    private static final LadderValueGenerator instance = new LadderRandomValueGenerator();
    private static final Random random = new Random();

    public static LadderValueGenerator getInstance() {
        return instance;
    }

    public Boolean generate() {
        return random.nextBoolean();
    }
}