package nextstep.refactor_ladder.domain.value;

import nextstep.refactor_ladder.strategy.LadderStrategy;

public enum Direction {
    RIGHT(false, true, 1),
    STAY(false, false, 0),
    LEFT(true, false, -1);

    private final boolean left;
    private final boolean right;
    private final int move;

    Direction(boolean left, boolean right, int move) {
        validateDirection(left, right);

        this.left = left;
        this.right = right;
        this.move = move;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public static Direction of(boolean left, boolean right) {
        for (Direction direction : Direction.values()) {
            if (direction.isLeft() == left && direction.right == right)
                return direction;
        }

        throw new IllegalArgumentException("값이 잘못되었습니다.");
    }

    public Direction next(LadderStrategy ladderStrategy) {
        if (prevRight()) {
            return next(false);
        }

        return next(ladderStrategy.generate());
    }

    public Direction last() {
        return of(prevRight(), false);
    }

    public boolean isLeft() {
        return left;
    }

    public int move() {
        return move;
    }

    private boolean prevRight() {
        return right;
    }

    private Direction next(boolean right) {
        return of(prevRight(), right);
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("방향을 연속해서 이동할 수 없습니다.");
        }
    }
}
