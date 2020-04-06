package nextstep.ladder.domain;

public enum Point {
    TRUE(true),
    FALSE(false);

    private boolean hasRightDirection;
    Point(boolean hasRightDirection) {
        this.hasRightDirection = hasRightDirection;
    }

    public Point reverse() {
        if(this == TRUE) {
            return FALSE;
        }
        return TRUE;
    }

    public boolean hasRightDirection() {
        return hasRightDirection;
    }
}
