package nextstep.step2.vo;

public enum Bridge {
    DOWN(0),
    RIGHT(1),
    LEFT(-1);

    private final int value;

    Bridge(int value) {
        this.value = value;
    }

    public static Bridge firstBridge(boolean random) {
        if (random) {
            return RIGHT;
        }

        return DOWN;
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
