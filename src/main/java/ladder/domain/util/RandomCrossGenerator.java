package ladder.domain.util;

import java.util.Random;

public class RandomCrossGenerator implements CrossGenerator {

    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }
}
