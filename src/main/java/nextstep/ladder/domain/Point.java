package nextstep.ladder.domain;

import nextstep.ladder.DrawStrategy;

public class Point {
    private boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public Point(DrawStrategy drawStrategy) {
        this.point = drawStrategy.isDraw();
    }

    public boolean isActive() {
        return point;
    }

}
