package ladder.model;

public class LadderDirection {
    private final boolean left;
    private final boolean right;

    LadderDirection(boolean left, boolean right) {
        validateNotBothDirections(left, right);
        this.left = left;
        this.right = right;
    }

    static LadderDirection first(boolean right) {
        return new LadderDirection(false, right);
    }

    static LadderDirection last(boolean left) {
        return new LadderDirection(left, false);
    }

    private void validateNotBothDirections(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 방향이 양쪽으로 있을 수 없습니다.");
        }
    }

    boolean isLeft() {
        return left;
    }

    boolean isRight() {
        return right;
    }
}
