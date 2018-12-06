package domain;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private static final int EDGE = 5;

    private final int bound;

    RandomValueGenerator(int bound) {
        this.bound = bound;
    }

    @Override
    public boolean generate() {
        Random r = new Random();
        int i = r.nextInt(bound);

        return i > EDGE;
    }
}
