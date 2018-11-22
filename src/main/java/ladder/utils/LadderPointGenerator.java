package ladder.utils;

import java.util.Random;

public class LadderPointGenerator implements PointGenerator{
    @Override
    public boolean generatePoint() {
        return new Random().nextBoolean();
    }
}
