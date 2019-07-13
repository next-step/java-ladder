package ladder.lineMaker;

import ladder.PointMakert;

import java.util.Random;

public class PointMakertRandom implements PointMakert {
    private Random random;

    public PointMakertRandom() {
        this.random = new Random();
    }

    @Override
    public Boolean nextBoolean() {
        return this.random.nextBoolean();
    }
}
