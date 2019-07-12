package ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private Random random = new Random();

    @Override
    public boolean generatePoint() {
        return random.nextBoolean();
    }
}
