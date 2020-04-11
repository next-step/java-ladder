package nextstep.ladder.domain;

import nextstep.ladder.RandomBooleanProvider;

public class Point {
    public static final String POINT_HAS_LINE_ERROR = "가로 라인이 겹치면 어느 방향으로 이동할 지 결정할 수 없습니다.";
    private int index;
    private boolean hasLine;

    public Point(int index, boolean hasLine) {
        this.index = index;
        this.hasLine = hasLine;
    }

    public Point(int index, Point previousPoint) {
        this.index = index;

        if(previousPoint != null && previousPoint.hasLine()) {
            this.hasLine = false;
            return ;
        }
        this.hasLine = RandomBooleanProvider.getRandomBoolean();
    }

    public boolean hasLine() {
        return hasLine;
    }

    public void compareWithPreviousPoint(Point point, Point previousPoint) {
        if(previousPoint.hasLine() && point.hasLine()) {
            throw new IllegalArgumentException(POINT_HAS_LINE_ERROR);
        }
    }

    public boolean isSameIndex(int index) {
        if(this.index == index) {
            return true;
        }
        return false;
    }
}
