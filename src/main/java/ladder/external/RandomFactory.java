package ladder.external;

import java.util.concurrent.ThreadLocalRandom;

public class RandomFactory {

    public boolean nextBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
