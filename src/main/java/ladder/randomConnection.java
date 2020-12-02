package ladder;

import java.util.Random;

public class randomConnection implements ConnectionStrategy {

    @Override
    public boolean connect(Boolean leftSideCondition) {
        Random random = new Random();

        return !leftSideCondition && random.nextBoolean();
    }
}
