package nextstep.ladder.support;

import java.util.Random;

public class DefaultRandomBoolean implements RandomBoolean{
    @Override
    public boolean nextBoolean() {
        return new Random().nextBoolean();
    }
}
