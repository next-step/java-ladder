package ladder.entity;

public class MoveRight implements MoveStrategy{

    @Override
    public Direction move() {
        return Direction.RIGHT;
    }
}
