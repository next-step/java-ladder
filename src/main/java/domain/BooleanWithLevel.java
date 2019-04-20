package domain;

import java.util.Random;

public class BooleanWithLevel implements BooleanGenerator {
    private static final int BOUND = 10;
    private Level level;

    public BooleanWithLevel(Level level) {
        this.level = level;
    }

    public boolean generatePoint() {
        return new Random().nextInt(BOUND) < level.getPercentage();
    }
}
