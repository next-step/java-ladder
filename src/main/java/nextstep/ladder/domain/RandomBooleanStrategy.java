package nextstep.ladder.domain;

import java.util.Random;

public class RandomBooleanStrategy implements BooleanStrategy {

    @Override
    public boolean value() {
        return new Random().nextBoolean();
    }
}
