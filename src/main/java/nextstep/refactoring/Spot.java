package nextstep.refactoring;

/**
 * 이동가능한 방향에 대한 상태값을 가짐
 * 1. 현재 상태에 따라 다음 이동 방향을 결정할 수 있음 (move())
 */
public class Spot {
    private final boolean left;
    private final boolean right;

    public Spot(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("올바르지 않은 상태값입니다.");
        }
        this.left = left;
        this.right = right;
    }

    public int move() {
        if (right) {
            return 1;
        }

        if (left) {
            return -1;
        }
        return 0;
    }
}
