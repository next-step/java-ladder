package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;

import nextstep.ladder.generator.PositionGenerator;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("왼쪽과 오른쪽 양쪽 방향성을 모두 갖을 수 없습니다.");
        }
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(PositionGenerator positionGenerator) {
        if (this.right) {
            return next(FALSE);
        }

        return next(positionGenerator.decideLineProduction());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }
}
