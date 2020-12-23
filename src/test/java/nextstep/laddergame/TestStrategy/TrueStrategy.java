package nextstep.laddergame.TestStrategy;

import nextstep.laddergame.domain.MovingStrategy;

public class TrueStrategy implements MovingStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
