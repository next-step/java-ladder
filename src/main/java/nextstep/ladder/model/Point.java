package nextstep.ladder.model;

import java.util.Arrays;

public enum Point {
    LEFT(true, false, -1),
    RIGHT(false, true, 1),
    NO_POINT(false, false, 0),
    ;
    private final boolean left;
    private final boolean right;
    private final int movePosition;

    Point(boolean left, boolean right, int movePosition) {
        this.left = left;
        this.right = right;
        this.movePosition = movePosition;
    }

    public int move(){
        return this.movePosition;
    }

}
