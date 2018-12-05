package domain;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private static final int BOUND = 10;
    private static final int EDGE = 5;

    @Override
    public boolean generate() {
        Random r = new Random();
        int i = r.nextInt(BOUND);

        return i > EDGE;
    }
}
