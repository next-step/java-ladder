package ladder.domain;

import java.util.Random;

public class RandomConnectionMode implements ConnectionMode {

    @Override
    public boolean generateConnection() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
