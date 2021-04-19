package step2.domain;

import static step2.domain.LadderType.EMPTY;
import static step2.domain.LadderType.LEFT;
import static step2.domain.LadderType.RIGHT;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {

    private static final Random random = new Random();

    @Override
    public LadderType next() {
        int rand = random.nextInt(2);
        if (rand == 1) {
            return EMPTY;
        }
        return RIGHT;
    }

    @Override
    public LadderType next(LadderType prev) {
        if (prev == RIGHT) {
            return LEFT;
        }
        return next();
    }
}
