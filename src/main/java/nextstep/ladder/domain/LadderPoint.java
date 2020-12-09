package nextstep.ladder.domain;

import java.util.Random;

public class LadderPoint {

    private static Random random = new Random();
    private final Direction direction;

    public LadderPoint() {
        this.direction = generateFirst();
    }

    public LadderPoint(boolean left, boolean right) {
        this.direction = Direction.of(left, right);
    }

    public LadderPoint(LadderPoint before, int ladderIndex, int ladderSize) {
        this.direction = getDirection(before, ladderIndex, ladderSize);
    }

    private Direction getDirection(LadderPoint beforeLadderPoint, int ladderIndex, int ladderSize) {
        if (ladderIndex == 0) {
            return generateFirst();
        }
        if (ladderIndex == ladderSize) {
            return generateLast(beforeLadderPoint.direction);
        }
        return generateNext(beforeLadderPoint.direction);
    }

    private Direction generateFirst() {
        return Direction.of(false, random.nextBoolean());
    }

    private Direction generateLast(Direction beforeDirection) {
        return Direction.of(beforeDirection, false);
    }

    private Direction generateNext(Direction beforeDirection) {
        if (beforeDirection.isRight()) {
            return Direction.of(true, false);
        }
        return Direction.of(false, random.nextBoolean());
    }

    public Direction getDirection() {
        return direction;
    }
}
