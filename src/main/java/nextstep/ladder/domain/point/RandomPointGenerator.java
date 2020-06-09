package nextstep.ladder.domain.point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private final Random random = new Random();

    @Override
    public boolean isRight() {
        return random.nextBoolean();
    }
}
