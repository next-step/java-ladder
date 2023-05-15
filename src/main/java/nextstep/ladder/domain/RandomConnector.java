package nextstep.ladder.domain;

import java.util.Random;

public class RandomConnector implements Connector {
    private final Random random = new Random();

    @Override
    public boolean connect() {
        return random.nextBoolean();
    }
}
