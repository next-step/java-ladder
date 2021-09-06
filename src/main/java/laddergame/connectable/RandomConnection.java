package laddergame.connectable;

import java.util.Random;

public class RandomConnection implements Connection {

    private static final Random random = new Random();

    @Override
    public Boolean able() {
        return random.nextBoolean();
    }
}
