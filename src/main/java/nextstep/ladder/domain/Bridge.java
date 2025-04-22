package nextstep.ladder.domain;

import java.util.Objects;

public class Bridge {
    public static final String INVALID_CONNECTION_ERROR = "사다리의 왼쪽과 오른쪽은 동시에 연결될 수 없습니다.";
    private final boolean left;
    private final boolean right;

    public Bridge(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(INVALID_CONNECTION_ERROR);
        }
    }

    public boolean isRightConnected() {
        return right;
    }

    public boolean notMatchWithNext(Bridge next) {
        return right != next.left;
    }

    public boolean notValidAsFirst() {
        return left;
    }

    public boolean notValidAsLast() {
        return right;
    }

    public Direction nextDirection() {
        if (right) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.STAY;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return left == bridge.left && right == bridge.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
