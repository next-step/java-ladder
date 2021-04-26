package step4.domain;

import java.util.Random;

public class LadderPointGenerator {
    private final Random random = new Random();

    public boolean generatePoint() {
        return random.nextBoolean();
    }


}
