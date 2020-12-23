package nextstep.laddergame.TestStrategy;

import nextstep.laddergame.domain.MovingStrategy;

public class FalseStrategy implements MovingStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}
