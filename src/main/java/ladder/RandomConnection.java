package ladder;

import java.util.Random;

public class RandomConnection implements HowToConnect {

    @Override
    public boolean connect(Boolean leftSideCondition) {
        Random random = new Random();

        return !leftSideCondition && random.nextBoolean();
    }
}
