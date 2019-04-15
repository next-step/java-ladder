package ladder.domain;

import java.util.Random;

public class BooleanGeneratorWithLevel implements BooleanGenerator {
    private static final int MAX_WEIGHT = 100;
    private Level level;

    public BooleanGeneratorWithLevel(Level level) {
        this.level = level;
    }

    public boolean generatePoint() {
        Random random = new Random();
        int r = random.nextInt(MAX_WEIGHT);
        if(r < level.getWeight()) {
            return true;
        }
        return false;
    }
}
