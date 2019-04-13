package ladder.domain;

import java.util.Random;

public class BooleanGenerator {
    private Level level;

    public BooleanGenerator(Level level) {
        this.level = level;
    }

    public boolean generatePoint() {
        Random random = new Random();
        int r = random.nextInt(100);
        if(r < level.getWeight()) {
            return true;
        }
        return false;
    }
}
