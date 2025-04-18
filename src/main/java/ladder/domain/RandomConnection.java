package ladder.domain;

import java.util.Random;

public class RandomConnection implements ConnectionStrategy{
    Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
