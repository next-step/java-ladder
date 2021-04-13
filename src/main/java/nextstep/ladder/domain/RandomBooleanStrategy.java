package nextstep.ladder.domain;

import java.util.Random;

public class RandomBooleanStrategy implements BooleanStrategy {

    private final Random random = new Random();

    @Override
    public boolean value(boolean value) {
        if (value) {
            return false;
        }
        return random.nextBoolean();
    }
}
