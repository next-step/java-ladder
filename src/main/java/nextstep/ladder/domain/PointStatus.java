package nextstep.ladder.domain;

import java.util.function.Supplier;

public enum PointStatus {
    LEFT,
    RIGHT,
    NONE,

    ;

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

}
