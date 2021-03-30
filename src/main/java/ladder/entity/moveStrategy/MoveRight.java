package ladder.entity.moveStrategy;

import ladder.entity.Direction;

public class MoveRight implements MoveStrategy {

    @Override
    public Direction move() {
        return Direction.RIGHT;
    }
}
