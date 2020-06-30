package nextstep.ladder.domain.fixture;

import nextstep.ladder.common.Direction;
import nextstep.ladder.domain.ladders.LineCreateStrategy;

public class RightConnectLineCreateStrategy implements LineCreateStrategy {

    @Override
    public Direction first() {
        return Direction.RIGHT;
    }

    @Override
    public Direction body(Direction exDirection) {
        return Direction.RIGHT;
    }

    @Override
    public Direction last(Direction exDirection) {
        return Direction.RIGHT;
    }
}
