package ladder.domain;

public abstract class DirectionStrategy {
    private Direction prevDirection = Direction.DOWN;

    abstract Direction get();

    Direction get(boolean isDown) {
        boolean isLeft = prevDirection == Direction.RIGHT;
        Direction direction = isLeft ? Direction.LEFT :
                isDown ? Direction.DOWN : Direction.RIGHT;
        prevDirection = direction;
        return direction;
    }

    void reset() {
        prevDirection = Direction.DOWN;
    }
}
