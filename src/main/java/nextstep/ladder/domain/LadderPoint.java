package nextstep.ladder.domain;


public class LadderPoint {

    private final Direction direction;
    private final DirectionStrategy directionStrategy;

    public LadderPoint(DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
        this.direction = generateFirst();
    }

    public LadderPoint(boolean left, boolean right, DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
        this.direction = Direction.of(left, right);
    }

    public LadderPoint(LadderPoint before, int ladderIndex, int ladderSize, DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
        this.direction = getDirection(before, ladderIndex, ladderSize);
    }

    private Direction getDirection(LadderPoint beforeLadderPoint, int ladderIndex, int ladderSize) {
        if (ladderIndex == 0) {
            return generateFirst();
        }
        if (ladderIndex == ladderSize - 1) {
            return generateLast(beforeLadderPoint.direction);
        }
        return generateNext(beforeLadderPoint.direction);
    }

    private Direction generateFirst() {
        return Direction.of(false, directionStrategy.next());
    }

    private Direction generateLast(Direction beforeDirection) {
        return Direction.of(beforeDirection, false);
    }

    private Direction generateNext(Direction beforeDirection) {
        if (beforeDirection.isRight()) {
            return Direction.of(true, false);
        }
        return Direction.of(false, directionStrategy.next());
    }

    public Direction getDirection() {
        return direction;
    }

    public int move(int index) {
        return direction.move(index);
    }
}
