package ladder.domain;

import java.util.Random;

public class RandomConnectionMode implements HowToConnect {

    @Override
    public boolean needToConnect(Boolean leftSideCondition) {
        Random random = new Random();

        return !leftSideCondition && random.nextBoolean();
    }
}
