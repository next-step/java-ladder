package ladder.domain;

public class DirectionNew {
    private final boolean left;
    private final boolean right;

    public DirectionNew(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽 방향을 동시에 가질 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public boolean hasRightDirection() {
        return right;
    }

    public boolean hasLeftDirection() {
        return left;
    }

    public boolean hasDirection() {
        return left || right;
    }
}
