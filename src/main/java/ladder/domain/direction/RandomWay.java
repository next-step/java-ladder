package ladder.domain.direction;

import java.util.Random;

public class RandomWay implements WayGenerator {
    @Override
    public boolean getWay() {
        return new Random().nextBoolean();
    }
}
