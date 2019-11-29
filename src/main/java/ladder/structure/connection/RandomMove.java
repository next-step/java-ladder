package ladder.structure.connection;

import java.util.Random;

public class RandomMove implements MoveStrategy {
    private static final Random random = new Random();

    private static boolean random(Movable point) {
        return point.isMovableToRight();
    }

    @Override
    public boolean isMovableToRight() {
        return random(random::nextBoolean);
    }
}
