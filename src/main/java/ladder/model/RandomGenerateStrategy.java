package ladder;

import java.util.Random;

public class RandomGenerateStrategy implements LadderGenerateStrategy {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }

}
