package rick.strategy;

import java.util.Random;

public class RandomPointCreationStrategy implements PointCreationStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean create() {
        return RANDOM.nextBoolean();
    }
}
