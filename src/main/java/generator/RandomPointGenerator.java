package generator;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    @Override
    public boolean random() {
        return new Random().nextBoolean();
    }
}
