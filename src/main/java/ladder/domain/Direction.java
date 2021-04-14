package ladder.domain;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("한 쪽의 방향만 입력할 수 있습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
