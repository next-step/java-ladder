package nextstep.ladder.domain;

import java.util.Random;
import nextstep.ladder.domain.interfaces.LineCreationStrategy;

public class RandomCreationStrategy implements LineCreationStrategy {
    @Override
    public boolean createLine() {
        return getRandomNum();
    }

    private boolean getRandomNum() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
