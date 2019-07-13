package ladder.lineMaker;

import ladder.LineMaker;

import java.util.Random;

public class LineMakerRandom implements LineMaker {
    private Random random;

    public LineMakerRandom() {
        this.random = new Random();
    }

    @Override
    public Boolean nextBoolean() {
        return this.random.nextBoolean();
    }
}
