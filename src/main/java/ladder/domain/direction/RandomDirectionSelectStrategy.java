package ladder.domain.direction;

import java.util.Random;

public class RandomDirectionSelectStrategy implements DirectionSelectStrategy {

    private final Random random = new Random();

    @Override
    public boolean isRight() {
        return random.nextBoolean();
    }
}
