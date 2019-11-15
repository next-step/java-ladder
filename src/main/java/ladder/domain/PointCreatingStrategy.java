package ladder.domain;

import java.util.Random;

public class PointCreatingStrategy implements CreatingStrategy {

    private final Random random = new Random();

    @Override
    public boolean isCreatable() {
        return random.nextBoolean();
    }
}
