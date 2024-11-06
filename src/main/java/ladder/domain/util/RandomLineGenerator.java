package ladder.domain.util;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {


    @Override
    public Boolean generate() {
        return new Random().nextBoolean();
    }
}
