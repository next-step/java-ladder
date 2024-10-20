package ladder;

import java.util.Random;

public class RandomLineGenerator implements LineGenerateStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public Boolean generate() {
        return RANDOM.nextBoolean();
    }
}
