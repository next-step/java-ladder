package ladder.entity.moveStrategy;

import ladder.entity.Direction;

public class MoveStill implements MoveStrategy {

    @Override
    public Direction move() {
        return Direction.STILL;
    }
}
