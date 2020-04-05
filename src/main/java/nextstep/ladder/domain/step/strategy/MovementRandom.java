package nextstep.ladder.domain.step.strategy;

import java.util.Random;

public class MovementRandom implements Movement {
    @Override
    public boolean isMovable() {
        return new Random().nextInt(10) >= 6;
    }
}
