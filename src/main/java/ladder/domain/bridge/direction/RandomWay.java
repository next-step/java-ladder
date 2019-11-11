package ladder.domain.bridge.direction;

import java.util.Random;

public class RandomWay implements WayGenerator {
    @Override
    public boolean getWay() {
        return new Random().nextBoolean();
    }
}
