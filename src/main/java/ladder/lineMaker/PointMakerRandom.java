package ladder.lineMaker;

import ladder.PointMaker;

import java.util.Random;

public class PointMakerRandom implements PointMaker {
    private Random random;

    public PointMakerRandom() {
        this.random = new Random();
    }

    @Override
    public Boolean nextBoolean() {
        return this.random.nextBoolean();
    }
}
