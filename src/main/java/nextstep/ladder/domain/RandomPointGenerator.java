package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    @Override
    public boolean generate() {
        boolean right;
        return new Random().nextBoolean();
    }

}
