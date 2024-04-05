package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;

import java.util.List;

public class MiddlePoint implements Point {

    private static final int LEFT_CACHE_INDEX = 0;
    private static final int RIGHT_CACHE_INDEX = 1;
    private static final int STAY_CACHE_INDEX = 2;
    private final MoveDirection moveDirection;

    private final static List<MiddlePoint> middlePointCache;

    static {
        middlePointCache = List.of(
                new MiddlePoint(MoveDirection.LEFT),
                new MiddlePoint(MoveDirection.RIGHT),
                new MiddlePoint(MoveDirection.STAY)
        );
    }

    public static MiddlePoint create(MoveDirection beforeDirection, MoveDirection moveDirection) {
        if (moveDirection.equals(MoveDirection.LEFT)) {
            return createLeft(beforeDirection);
        }

        if (moveDirection.equals(MoveDirection.RIGHT)) {
            return createRight(beforeDirection);
        }

        return createStay(beforeDirection);
    }

    private static MiddlePoint createLeft(MoveDirection moveDirection) {
        validateWithBefore(moveDirection, MoveDirection.LEFT);
        return middlePointCache.get(LEFT_CACHE_INDEX);
    }

    private static MiddlePoint createRight(MoveDirection moveDirection) {
        validateWithBefore(moveDirection, MoveDirection.RIGHT);
        return middlePointCache.get(RIGHT_CACHE_INDEX);
    }

    private static MiddlePoint createStay(MoveDirection moveDirection) {
        validateWithBefore(moveDirection, MoveDirection.STAY);
        return middlePointCache.get(STAY_CACHE_INDEX);
    }

    private MiddlePoint(MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
    }

    private static void validateWithBefore(MoveDirection beforeDirection, MoveDirection currentDirection) {
        if (beforeDirection.equals(MoveDirection.LEFT) && currentDirection.equals(MoveDirection.LEFT)) {
            throw new IllegalArgumentException("올바르지 못한 Line 입니다.");
        }

        if (beforeDirection.equals(MoveDirection.STAY) && currentDirection.equals(MoveDirection.LEFT)) {
            throw new IllegalArgumentException("올바르지 못한 Line 입니다.");
        }

        if (beforeDirection.equals(MoveDirection.RIGHT) && currentDirection.equals(MoveDirection.RIGHT)) {
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
    public int getDirection() {
        return this.moveDirection.getDirection();
    }

    @Override
    public MoveDirection getMoveDirection() {
        return this.moveDirection;
    }

    @Override
    public boolean isLeft() {
        return this.moveDirection.equals(MoveDirection.LEFT);
    }

    @Override
    public boolean isRight() {
        return this.moveDirection.equals(MoveDirection.RIGHT);
    }

    @Override
    public boolean isStay() {
        return this.moveDirection.equals(MoveDirection.STAY);
    }
}
