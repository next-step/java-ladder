package nextstep.ladder.domain;

import java.util.Random;

public class LadderLineCreationStrategy implements LineCreationStrategy {
    @Override
    public boolean createLine() {
        return getRandomNum();
    }

    @Override
    public boolean isOrNoneDrawLines(Line line) {
        return line.isExist();
    }

    private boolean getRandomNum() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
