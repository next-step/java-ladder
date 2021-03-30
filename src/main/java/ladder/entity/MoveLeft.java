package ladder.entity;

public class MoveLeft implements MoveStrategy {

    @Override
    public Direction move() {
        return Direction.LEFT;
    }
}
