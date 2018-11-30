package ladderTDD.domain;

import ladder.utils.GenerateRandomUtil;
import ladderTDD.domain.levels.LadderLevel;

public class Direction {

    private static final Direction STAY_DIRECTION = new Direction(false, false);
    private static final Direction LEFT_DIRECTION = new Direction(true, false);
    private static final Direction RIGHT_DIRECTION = new Direction(false, true);

    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (DirectionEnum.SYAY == DirectionEnum.valueOf(left, right)) {
            return STAY_DIRECTION;
        }

        if (DirectionEnum.LEFT == DirectionEnum.valueOf(left, right)) {
            return LEFT_DIRECTION;
        }

        if (DirectionEnum.RIGHT == DirectionEnum.valueOf(left, right)) {
            return RIGHT_DIRECTION;
        }

        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    @Override
    public boolean equals(Object obj) {
        Direction otherDirection = (Direction)obj;
        if (this.left == otherDirection.left && this.right == otherDirection.right) {
            return true;
        }
        return false;
    }

    public Direction next(LadderLevel ladderLevel) {
        if (this.right) {
            return of(this.right, false);
        }
        return of(this.right, ladderLevel.generateRandomValue());
    }

    public Direction next(boolean right) {
        return of(this.right, right);
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction last() {
        return of(this.right, false);
    }

    public boolean isRight() {
        return this.right;
    }
}
