package ladder.domain.bridge;

import java.util.Random;

public class RandomWay implements WayGenerator {
    @Override
    public boolean getWay() {
        return new Random().nextBoolean();
    }
}
