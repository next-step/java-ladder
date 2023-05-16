package ladder.strategy;

import java.util.Random;

public class RandomMovableStrategy implements MoveStratege {
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextBoolean();
    }
}
