package step2.ganerator;

import java.util.Random;

public class LadderGenerator implements RandomGenerator{

    private final Random random = new Random();

    @Override
    public boolean randomLadder() {
        return random.nextBoolean();
    }
}
