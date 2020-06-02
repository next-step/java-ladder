package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private Random random;

    public RandomBridgeGenerator(Random random) {
        if (Objects.isNull(random)) {
            throw new IllegalArgumentException("random is required");
        }
        this.random = random;
    }

    @Override
    public boolean isCrossBridge() {
        return this.random.nextBoolean();
    }
}
