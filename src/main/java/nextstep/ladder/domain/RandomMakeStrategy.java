package nextstep.ladder.domain;

import java.util.Random;

public class RandomMakeStrategy implements LineMakeStrategy {
    @Override
    public boolean canMake() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
