package nextstep.ladder.domain.generator;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator{

    private final static Random random = new Random();
    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
