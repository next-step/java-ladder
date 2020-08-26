package ladder.domain;

import java.util.Random;

public class LineRandomGenerator implements LineGenerator{
    private static final Random random = new Random();

    @Override
    public boolean getRight() {
        return random.nextBoolean();
    }

}
