package step2.domain;

import java.util.Random;

public class PointRandomStrategy implements PointStrategy{
    private final Random random = new Random();

    @Override
    public boolean create() {
        return random.nextBoolean();
    }
}
