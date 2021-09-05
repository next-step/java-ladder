package step4.ladderGame.domain.ladder.GenerateDirectionStrategy;

import java.util.Random;

public class GenerateRandomDirectionStrategy implements GenerateDirectionStrategy {

    private static Random random = new Random();

    public boolean generateDirection(final boolean right) {
        if (right) {
            return false;
        }
        return random.nextBoolean();
    }

    public boolean generateDirection() {
        return random.nextBoolean();
    }

}
