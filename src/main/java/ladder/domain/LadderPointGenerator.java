package ladder.domain;

import java.util.Random;

public class LadderPointGenerator implements PointGenerator {
    public boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
