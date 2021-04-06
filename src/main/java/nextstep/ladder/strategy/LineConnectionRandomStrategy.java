package nextstep.ladder.strategy;

import java.util.Random;

public class LineConnectionRandomStrategy implements LineConnectionStrategy {

    private static final Random random = new Random();

    @Override
    public boolean createLine(boolean previousLine) {
        if (previousLine) {
            return false;
        }
        return random.nextBoolean();
    }
}
