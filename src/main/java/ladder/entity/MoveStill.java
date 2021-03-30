package ladder.entity;

public class MoveStill implements MoveStrategy {

    @Override
    public Direction move() {
        return Direction.STILL;
    }
}
