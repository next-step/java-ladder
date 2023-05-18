package step3.domain;

import java.util.concurrent.ThreadLocalRandom;

public class DirectionMoveStrategy implements MoveStrategy {
    @Override
    public boolean move() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
