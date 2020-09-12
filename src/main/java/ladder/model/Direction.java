package ladder.model;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("방향은 왼쪽, 오른쪽 중 하나만 가질 수 있습니다.");
        }
    }

    public int move() {
        if (left) {
            return -1;
        }

        if (right) {
            return 1;
        }

        return 0;
    }

}
