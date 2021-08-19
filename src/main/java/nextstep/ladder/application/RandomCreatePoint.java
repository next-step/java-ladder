package nextstep.ladder.application;

import java.util.Random;

public class RandomCreatePoint implements CreatePointStrategy {
    private static final RandomCreatePoint randomCreatePoint = new RandomCreatePoint();
    private static final Random random = new Random();

    private RandomCreatePoint() {
    }

    public boolean isDraw() {
        return random.nextBoolean();
    }

    public static final CreatePointStrategy of() {
        return randomCreatePoint;
    }
}
