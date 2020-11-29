package ladder.domain;

import java.util.Random;

public class LadderMoveStrategy implements MoveStrategy{

    private final static Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextBoolean();
    }
}
