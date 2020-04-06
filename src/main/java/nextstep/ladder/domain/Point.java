package nextstep.ladder.domain;

public class Point {
    public static final String POINT_HAS_LINE_ERROR = "가로 라인이 겹치면 어느 방향으로 이동할 지 결정할 수 없습니다.";
    private int index;
    private boolean hasLine;

    public Point(int index, boolean hasLine) {
        this.index = index;
        this.hasLine = hasLine;
    }

    public boolean hasLine() {
        return hasLine;
    }

    public void compareWithPreviousPoint(Point point, Point previousPoint) {
        if(previousPoint.hasLine() && point.hasLine()) {
            throw new IllegalArgumentException(POINT_HAS_LINE_ERROR);
        }
    }
}
