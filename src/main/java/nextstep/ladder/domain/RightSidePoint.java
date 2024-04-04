package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;

import java.util.List;

public class RightSidePoint implements Point {

    private static final int STAY_CACHE_INDEX = 0;
    private static final int LEFT_CACHE_INDEX = 1;
    private final static List<RightSidePoint> rightSidePointCache;
    private final MoveDirection moveDirection;

    static {
        rightSidePointCache = List.of(
                new RightSidePoint(MoveDirection.STAY),
                new RightSidePoint(MoveDirection.LEFT)
        );
    }

    public static RightSidePoint create(MoveDirection beforeDirection, MoveDirection moveDirection) {
        if (moveDirection.equals(MoveDirection.RIGHT)) {
            throw new IllegalArgumentException("끝나는 위치는 오른쪽을 가리킬 수 없습니다.");
        }

        if (moveDirection.equals(MoveDirection.LEFT)) {
            return createLeft(beforeDirection);
        }

        return createStay(beforeDirection);
    }

    private static RightSidePoint createStay(MoveDirection beforeDirection) {
        validateWithBefore(beforeDirection, MoveDirection.STAY);
        return rightSidePointCache.get(STAY_CACHE_INDEX);
    }

    private static RightSidePoint createLeft(MoveDirection beforeDirection) {
        validateWithBefore(beforeDirection, MoveDirection.LEFT);
        return rightSidePointCache.get(LEFT_CACHE_INDEX);
    }

    private RightSidePoint(MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
    }

    private static void validateWithBefore(MoveDirection beforeDirection, MoveDirection currentDirection) {
        if (beforeDirection.equals(MoveDirection.LEFT) && currentDirection.equals(MoveDirection.LEFT)) {
            throw new IllegalArgumentException("올바르지 못한 Line 입니다.");
        }

        if (beforeDirection.equals(MoveDirection.STAY) && currentDirection.equals(MoveDirection.LEFT)) {
            throw new IllegalArgumentException("올바르지 못한 Line 입니다.");
        }

        if (beforeDirection.equals(MoveDirection.RIGHT) && currentDirection.equals(MoveDirection.STAY)) {
            throw new IllegalArgumentException("올바르지 못한 Line 입니다.");
        }
    }

    @Override
    public int movePosition(int currentPosition) {
        return currentPosition + this.moveDirection.getDirection();
    }

    @Override
    public int getMoveDirection() {
        return this.moveDirection.getDirection();
    }
}
