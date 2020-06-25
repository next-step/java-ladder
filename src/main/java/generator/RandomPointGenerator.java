package generator;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    @Override
    public boolean isConnect(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }

        return new Random().nextBoolean();
    }

    @Override
    public boolean random() {
        return new Random().nextBoolean();
    }
}
