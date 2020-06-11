package ladder.domain;

import java.util.Random;

public class RandomPointGenerationStrategy implements PointGenerationStrategy {
    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }
}
