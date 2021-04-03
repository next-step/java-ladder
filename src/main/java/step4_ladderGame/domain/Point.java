package step4_ladderGame.domain;

public class Point {

    private final boolean prevPoint;
    private final boolean curPoint;

    private Point(boolean prevPoint, boolean curPoint) {
        if (prevPoint && curPoint) {
            throw new IllegalArgumentException("연속된 사다리 연결 point 생성은 불가합니다.");
        }
        this.prevPoint = prevPoint;
        this.curPoint = curPoint;
    }

    public static Point of(boolean prevPoint, boolean curPoint) {
        return new Point(prevPoint, curPoint);
    }
}

