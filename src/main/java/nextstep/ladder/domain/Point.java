package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

public class Point {
    private boolean currentPoint;
    private boolean nextPoint;

    private Point(boolean nextPoint) {
        this.currentPoint = false;
        this.nextPoint = nextPoint;
    }

    private Point(boolean currentPoint, boolean nextPoint) {
        this.currentPoint = currentPoint;
        this.nextPoint = nextPoint;
    }

    public static Point init() {
        return new Point(RandomUtil.generate());
    }

    public static Point of() {
        return new Point(true, RandomUtil.generate());
    }


    public boolean nextPoint() {
        return nextPoint;
    }
}
