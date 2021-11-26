package nextstep.ladder.domain.rule;

import java.util.Random;

public class RandomPointRule implements PointRule {

    private static final Random random = new Random();

    @Override
    public boolean canCreate() {
        return random.nextBoolean();
    }

}
