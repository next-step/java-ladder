package ladder.model;

import java.util.Random;

public class LineStrategyRamdom implements LineStrategy {

    @Override
    public boolean addLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
