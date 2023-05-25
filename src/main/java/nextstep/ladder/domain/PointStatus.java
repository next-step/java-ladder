package nextstep.ladder.domain;

import java.util.function.Supplier;

public enum PointStatus {
    LEFT,
    RIGHT,
    NONE,

    ;

    public static PointStatus getRandomStatus(int number) {
        return values()[number];
    }

}
