package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;

import java.util.List;

public class LeftSidePoint implements Point {

    private static final int STAY_CACHE_INDEX = 0;
    private static final int RIGHT_CACHE_INDEX = 1;
    private final static List<LeftSidePoint> leftSidePointCache;
    private final MoveDirection moveDirection;

    static {
        leftSidePointCache = List.of(
                new LeftSidePoint(MoveDirection.STAY),
                new LeftSidePoint(MoveDirection.RIGHT)
        );
    }

    public static LeftSidePoint create(MoveDirection moveDirection) {
        validateFirstDirection(moveDirection);

        if (moveDirection.equals(MoveDirection.STAY)) {
            return createStay();
        }

        return createRight();
    }

    private static void validateFirstDirection(MoveDirection moveDirection) {
        if (moveDirection.equals(MoveDirection.LEFT)) {
            throw new IllegalArgumentException("시작되는 위치는 왼쪽을 가리킬 수 없습니다.");
        }
    }

    private static LeftSidePoint createStay() {
        return leftSidePointCache.get(STAY_CACHE_INDEX);
    }

    private static LeftSidePoint createRight() {
        return leftSidePointCache.get(RIGHT_CACHE_INDEX);
    }

    private LeftSidePoint(MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
    }

    @Override
    public int movePosition(int currentPosition) {
        return currentPosition + this.moveDirection.getDirection();
    }

    @Override
    public int getDirection() {
        return this.moveDirection.getDirection();
    }

    @Override
    public MoveDirection getMoveDirection() {
        return this.moveDirection;
    }
}
