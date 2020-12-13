package ladder.domain;

import java.util.Random;

public class RandomLadderGenerateStrategy implements LadderGenerateStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isGenerating() {
        return random.nextBoolean();
    }
}
