package nextstep.ladder.domain;

import java.util.Random;

public class RandomDraw implements Draw {
    private static final int RANDOM_BOUND_ZERO_TO_NINE = 2;
    private static final int DRAW_CONDITION = 1;
    private static final Random RANDOM = new Random();

    @Override
    public boolean draw() {
        return RANDOM.nextInt(RANDOM_BOUND_ZERO_TO_NINE) == DRAW_CONDITION;
    }
}
