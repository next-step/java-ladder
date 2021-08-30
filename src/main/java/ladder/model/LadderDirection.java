package ladder.model;

public class LadderDirection {
    private final boolean left;
    private final boolean right;

    LadderDirection(boolean left, boolean right) {
        validateNotBothDirections(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateNotBothDirections(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 방향이 양쪽으로 있을 수 없습니다.");
        }
    }
}
