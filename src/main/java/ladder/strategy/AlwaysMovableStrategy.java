package ladder.strategy;

import ladder.domain.Direction;

public class AlwaysMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
