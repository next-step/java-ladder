package nextstep.ladder.domain.lines;

import java.util.Random;

public class DefaultRandomService implements RandomService {
    private final Random random;

    public DefaultRandomService(Random random) {
        this.random = random;
    }

    @Override
    public Boolean nextBoolean() {
        return random.nextBoolean();
    }
}
