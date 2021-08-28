package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

public class Point {
    private boolean currentPoint;
    private boolean nextPoint;

    private Point(boolean nextPoint) { // init
        this.currentPoint = false;
        this.nextPoint = nextPoint;
    }

    private Point() { // of
        this.currentPoint = true;
        this.nextPoint = false;
    }

    public static Point init() { // 현재 값이 false 이면 다음 값은 랜덤
        return new Point(RandomUtil.generate());
    }

    public static Point of() {
        return new Point(); // 현재 값이 true이면 다음 값은 무조건 false이다.
    }


    public boolean nextPoint() {
        return nextPoint;
    }
}
