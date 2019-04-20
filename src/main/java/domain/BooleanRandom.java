package domain;

import java.util.Random;

public class BooleanRandom implements BooleanGenerator {

    @Override
    public boolean generatePoint() {
        return new Random().nextBoolean();
    }
}
