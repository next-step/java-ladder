package generator;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    @Override
    public boolean next(boolean previousPoint) {
        if (previousPoint) {
            return Boolean.FALSE;
        }

        return new Random().nextBoolean();
    }

    @Override
    public boolean random() {
        return new Random().nextBoolean();
    }
}
