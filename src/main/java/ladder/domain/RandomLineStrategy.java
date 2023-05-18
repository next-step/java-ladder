package ladder.domain;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {

    private final Random RANDOM = new Random();

    @Override
    public boolean add() {
        return RANDOM.nextBoolean();
    }
}
