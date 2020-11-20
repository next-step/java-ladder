package ladder.domain;

class DirectionGenerator {
    private Direction prevDirection = Direction.DOWN;

    Direction generateDirection(boolean isDown) {
        boolean isLeft = prevDirection == Direction.RIGHT;
        Direction direction = isLeft ? Direction.LEFT :
                isDown ? Direction.DOWN : Direction.RIGHT;
        prevDirection = direction;
        return direction;
    }
}
