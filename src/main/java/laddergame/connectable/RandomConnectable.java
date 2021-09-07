package laddergame.connectable;

import laddergame.ladder.Connection;

import java.util.Random;

public class RandomConnectable implements Connectable {

    private static final Random random = new Random();

    @Override
    public Connection value() {
        return Connection.of(random.nextBoolean());
    }
}
