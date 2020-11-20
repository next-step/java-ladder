package ladder.domain;

class DirectionGenerator {
    private Direction prevDirection = Direction.DOWN;

    Direction generateDirection(boolean isDown) {
        Direction direction = prevDirection == Direction.RIGHT
                ? Direction.LEFT
                : isDown
                ? Direction.DOWN
                : Direction.RIGHT;
        prevDirection = direction;
        return direction;
    }
}
