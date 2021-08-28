package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

public class Point {
    private boolean currentPoint;
    private boolean nextPoint;

    public Point(boolean nextPoint) {
        this.currentPoint = false;
        this.nextPoint =  nextPoint;
    }

    public Point(boolean currentPoint, boolean nextPoint) {
        this.currentPoint = currentPoint;
        this.nextPoint = nextPoint;
    }

    public static Point init() {
        return new Point(false, RandomUtil.generate());
    }



    public boolean previousPoint () {
        return nextPoint;
    }
}
