package nextstep.ladder.domain;

import java.util.*;

public class LinePoint {
    private static final Map<MoveDirection, LinePoint> cache;
    private final boolean left;
    private final boolean right;


    static {
        cache = new EnumMap<>(MoveDirection.class);

        cache.put(MoveDirection.LEFT, new LinePoint(true, false));
        cache.put(MoveDirection.RIGHT, new LinePoint(false, true));
        cache.put(MoveDirection.NON, new LinePoint(false, false));
    }

    private LinePoint(boolean left, boolean right) {
        assertNotBothTrue(left, right);
        this.left = left;
        this.right = right;
    }

    private void assertNotBothTrue(boolean left, boolean right) {
        String bothTrueMessage = "[사다리 포인트] 연속으로 라인이 생길 수 없습니다.";

        if (left && right) {
            throw new IllegalArgumentException(bothTrueMessage);
        }
    }

    public static LinePoint of(MoveDirection moveDirection) {
        String notFoundMessage = "[사다리 포인트] 해당 방향의 포인트는 없습니다.";

        LinePoint linePoint = cache.get(moveDirection);
        if (linePoint == null) {
            throw new NoSuchElementException(notFoundMessage);
        }

        return linePoint;
    }

    public boolean canMoveLeft() {
        return left;
    }

    public boolean canMoveRight() {
        return right;
    }


}
