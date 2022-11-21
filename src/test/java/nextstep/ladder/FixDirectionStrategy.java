package nextstep.ladder;

import nextstep.ladder.domain.DirectionStrategy;

public class FixDirectionStrategy implements DirectionStrategy {
    @Override
    public boolean isRight() {
        return true;
    }
}
