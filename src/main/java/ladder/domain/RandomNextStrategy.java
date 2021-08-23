package ladder.domain;

import java.util.Random;

public class RandomNextStrategy implements NextStrategy {
    private final Random random = new Random();

    @Override
    public boolean execute() {
        return random.nextBoolean();
    }
}
