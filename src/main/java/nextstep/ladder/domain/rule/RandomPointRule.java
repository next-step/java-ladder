package nextstep.ladder.domain.rule;

import java.util.Random;

public class RandomPointRule implements PointRule {

    private static final Random RANDOM = new Random();

    @Override
    public boolean canCreate() {
        return RANDOM.nextBoolean();
    }

}
