package nextstep.ladder.domain.ladder;

import java.util.Random;

public class DirectionRandomPredicate implements DirectionPredicate {

    private static final Random RANDOM = new Random();

    @Override
    public boolean test() {
        return RANDOM.nextBoolean();
    }
}
