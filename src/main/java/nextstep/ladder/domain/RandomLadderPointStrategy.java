package nextstep.ladder.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class RandomLadderPointStrategy implements LadderPointGenerateStrategy {
    private static final Random RANDOM = new Random();

    private final AtomicBoolean previousPoint = new AtomicBoolean(RANDOM.nextBoolean());

    @Override
    public boolean generatePoint() {
        return previousPoint.getAndSet(!previousPoint.get() && RANDOM.nextBoolean());
    }
}
