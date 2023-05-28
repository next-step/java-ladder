package nextstep.ladder.domain;

import java.util.function.Supplier;

public enum PointStatus {

    LEFT,
    RIGHT,
    NONE,

    ;

    public static final int TOTAL_INDEX_SIZE = values().length;
    public static final int TWO_RESULT_SIZE = 2;

    public boolean hasLeft() {
        return LEFT == this;
    }

    public boolean hasRight() {
        return RIGHT == this;
    }

    public boolean hasNone() {
        return NONE == this;
    }

    public static PointStatus getRandomStatus(int number) {
        return values()[number];
    }

    public static PointStatus getRandomStatusExceptRight(int number) {
        if (number == 0) {
            return NONE;
        }
        return LEFT;
    }

    public static PointStatus getRandomStatusExceptLeft(int number) {
        if (number == 0) {
            return NONE;
        }
        return RIGHT;
    }

}
