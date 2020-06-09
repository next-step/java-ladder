package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class RandomMovementGenerator implements MovementGenerator {
    private Random random;

    public RandomMovementGenerator(Random random) {
        if (Objects.isNull(random)) {
            throw new IllegalArgumentException("random is required");
        }
        this.random = random;
    }

    @Override
    public boolean isMove() {
        return this.random.nextBoolean();
    }
}
