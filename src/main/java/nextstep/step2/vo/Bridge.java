package nextstep.step2.vo;

public enum Bridge {
    DOWN(0),
    RIGHT(1),
    LEFT(-1);

    private final int moveValue;

    Bridge(int moveValue) {
        this.moveValue = moveValue;
    }

    public static Bridge firstBridge(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }

        return DOWN;
    }

    public int getMoveValue() {
        return moveValue;
    }

    public Bridge next(boolean isRight, boolean isLast) {
        if (this.equals(Bridge.RIGHT)) {
            return LEFT;
        }

        if (isLast) {
            return DOWN;
        }

        if (isRight) {
            return RIGHT;
        }

        return DOWN;
    }
}
