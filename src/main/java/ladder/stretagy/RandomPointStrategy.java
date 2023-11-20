package ladder.stretagy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPointStrategy implements PointBuildStrategy {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean build() {
        return random.nextBoolean();
    }
}
