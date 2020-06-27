package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointStrategy implements GeneratePointStrategy {

    private static final Random random = new Random();

    @Override
    public boolean isLine(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }

        return random.nextBoolean();
    }
}
