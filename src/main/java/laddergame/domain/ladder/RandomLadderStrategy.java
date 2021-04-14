package laddergame.domain.ladder;

import java.util.Random;

public class RandomLadderStrategy implements LadderStrategy {
    @Override
    public boolean test() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
