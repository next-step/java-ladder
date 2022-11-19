package nextstep.ladder.utils;

import nextstep.ladder.domain.Movable;

import java.util.Random;

public class RandomValueGenerator implements Movable {
    private static Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
