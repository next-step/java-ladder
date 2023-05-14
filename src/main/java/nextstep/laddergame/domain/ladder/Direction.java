package nextstep.laddergame.domain.ladder;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.checkDuplicateDirection(left, right);

        this.left = left;
        this.right = right;
    }

    private void checkDuplicateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리는 좌우 동시에 연결될 수 없습니다.");
        }
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction next(boolean right) {
        return new Direction(this.right, right);
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    public DirectionType move() {
        return DirectionType.checkDirection(this.left, this.right);
    }
}
