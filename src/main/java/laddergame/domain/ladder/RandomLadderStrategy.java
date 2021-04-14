package laddergame.domain.ladder;

import java.util.Random;

public class RandomLadderStrategy implements LadderStrategy {
    private final Random random = new Random();
    @Override
    public boolean test() {
        return random.nextBoolean();
    }
}
