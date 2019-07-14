package ladder.domain;

import java.util.Random;

public class RandomPointIndicator implements PointIndicator {

    private Random random = new Random();

    @Override
    public boolean generatePoint() {
        return random.nextBoolean();
    }
}
