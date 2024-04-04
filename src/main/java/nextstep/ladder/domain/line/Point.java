package nextstep.ladder.domain.line;

public class Point {

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isLadderConstructionStatusFalse() {
        return !point;
    }
}
