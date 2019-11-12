package ladder.game;

import java.util.Random;

public class RandomConnection implements ConnectionStrategy {
    private static final Random random = new Random();
    private static boolean random(Connectable connection) {
        return connection.create();
    }

    @Override
    public boolean create() {
        return random(random::nextBoolean);
    }
}
