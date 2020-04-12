package ladder.domain;

import ladder.utils.RandomUtils;

public class LadderRandomMoveStrategy implements LadderMoveStrategy {

    @Override
    public boolean move() {
        return RandomUtils.getRandomBoolean();
    }
}
