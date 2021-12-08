package ladder;

import static ladder.Direction.*;

/**
 * field 값이 true 인 경우 자신을 기준으로 오른쪽으로 가로 줄이 생성된다.
 *
 * Ex) true false
 *     |-----|
 *
 *     false true
 *     |     |-----
 *
 *     false false
 *     |     |
 *
 * 첫번째 element 의 경우 left field 에 가상의 false 가 있다고 가정한다.
 * 마지막 element 의 경우 curr 는 항상 false 이어야 한다.
 */
public class PointElement {
    private final boolean left;
    private final boolean curr;

    private PointElement(boolean left, boolean curr) {
        this.left = left;
        this.curr = curr;

        if (left & curr) {
            throw new IllegalArgumentException("유효하지 않은 상태입니다.");
        }
    }

    public static PointElement first(boolean curr) {
        return new PointElement(false, curr);
    }

    public PointElement next(boolean curr) {
        return new PointElement(this.curr, curr);
    }

    public PointElement last() {
        return new PointElement(this.curr, false);
    }

    public Direction move() {
        if (curr) {
            return RIGHT;
        }

        if (left) {
            return LEFT;
        }

        return PASS;
    }
}
