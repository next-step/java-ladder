package ladder.domain;

public enum LadderPoint {
    VERTICAL_POINT("|"),
    CONNECTED_POINT("-----"),
    EMPTY_POINT("     ");

    private final String point;

    LadderPoint(String point) {
        this.point = point;
    }

    public static boolean isHorizontal(LadderPoint ladderPoint) {
        return ladderPoint != VERTICAL_POINT;
    }

    @Override
    public String toString() {
        return point;
    }
}
