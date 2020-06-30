package nextstep.ladder.domain.fixture;

import nextstep.ladder.common.Direction;
import nextstep.ladder.domain.ladders.LineCreateStrategy;

public class LeftConnectLineCreateStrategy implements LineCreateStrategy {

    @Override
    public Direction first() {
        return Direction.LEFT;
    }

    @Override
    public Direction body(Direction exDirection) {
        return Direction.LEFT;
    }

    @Override
    public Direction last(Direction exDirection) {
        return Direction.LEFT;
    }
}
