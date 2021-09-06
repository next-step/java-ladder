package laddergame.connectable;

import java.util.Random;

public class RandomConnectable implements Connectable {

    private static final Random random = new Random();

    @Override
    public Boolean able() {
        return random.nextBoolean();
    }
}
