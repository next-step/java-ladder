package ladder.entity.moveStrategy;

import ladder.entity.Direction;

public class MoveLeft implements MoveStrategy {

    @Override
    public Direction move() {
        return Direction.LEFT;
    }
}
