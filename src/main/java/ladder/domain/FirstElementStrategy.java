package ladder.domain;

import ladder.util.RandomUtil;

public class FirstElementStrategy implements LadderStrategy {

    public FirstElementStrategy() {
    }

    @Override
    public Direction direction() {
        if (RandomUtil.trueOrFalse()) {
            return Direction.RIGHT;
        }
        return Direction.NO_DIRECTION;
    }
}
