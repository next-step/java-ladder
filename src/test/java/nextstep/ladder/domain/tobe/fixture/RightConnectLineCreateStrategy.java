package nextstep.ladder.domain.tobe.fixture;

import nextstep.ladder.domain.tobe.Direction;
import nextstep.ladder.domain.tobe.LineCreateStrategy;

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
