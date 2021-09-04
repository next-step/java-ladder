package ladder.strategy;

import java.util.Random;

public class RandomLineGenerateStrategy implements LineGenerateStrategy {

    private static final RandomLineGenerateStrategy INSTANCE = new RandomLineGenerateStrategy();

    public static RandomLineGenerateStrategy getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean generateLine() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
