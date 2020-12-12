package ladder.domain;

import java.util.Random;

public class RandomConnectionMode implements HowToConnect, ConnectionMode {

    @Override
    public boolean needToConnect(Boolean leftSideCondition) {
        Random random = new Random();

        return !leftSideCondition && random.nextBoolean();
    }

    @Override
    public boolean generateConnection() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
