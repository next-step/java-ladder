package ladder.domain;

import java.util.Random;

public class RandomBarGenerator implements BarGenerator{

    private Random random = new Random();

    @Override
    public boolean generateBar() {
        return random.nextBoolean();
    }
}
