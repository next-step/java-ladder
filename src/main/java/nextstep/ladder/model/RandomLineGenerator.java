package nextstep.ladder.model;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
