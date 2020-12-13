package nextstep.step4.domain;

import java.util.Random;

public class RandomMoveImpl implements MoveStrategy {
    private final static Random random = new Random();

    @Override
    public boolean move(boolean previous) {
        if(previous) {
            return false;
        }
        return random.nextBoolean();
    }
}
