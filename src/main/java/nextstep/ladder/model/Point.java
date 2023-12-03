package nextstep.ladder.model;

import java.util.Arrays;

public enum Point {
    LEFT(true, false),
    RIGHT(false, true),
    NO_POINT(false, false),
    ;
    private final boolean left;
    private final boolean right;

    Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }
}
