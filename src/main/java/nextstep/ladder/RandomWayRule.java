package nextstep.ladder;

import java.util.Random;

public class RandomWayRule implements WayRule {

    private static final Random RANDOM = new Random();

    @Override
    public boolean canCreate() {
        return RANDOM.nextBoolean();
    }
}
