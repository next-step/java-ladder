package nextstep.ladder.domain.tobe.fixture;

import nextstep.ladder.domain.tobe.Direction;
import nextstep.ladder.domain.tobe.LineCreateStrategy;

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
