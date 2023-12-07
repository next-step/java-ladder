package nextstep.ladder.domain.lines;

import java.util.Random;

public class DefaultRandomService implements RandomService {
    private final Random random = new Random();

    @Override
    public Boolean nextBoolean() {
        return random.nextBoolean();
    }
}
