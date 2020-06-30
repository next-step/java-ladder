package nextstep.ladder.domain.ladders;

import nextstep.ladder.common.Direction;

public interface LineCreateStrategy {
    public Direction first();

    public Direction body(Direction exDirection);

    public Direction last(Direction exDirection);
}
