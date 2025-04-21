package ladder;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy{
    private final Random random = new Random();
    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
