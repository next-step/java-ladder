package ladder.generator;

import java.util.Random;

public class LineStrategy implements Strategy {
    private final Random random = new Random();

    @Override
    public boolean randomLadder() {
        return random.nextBoolean();
    }
}
