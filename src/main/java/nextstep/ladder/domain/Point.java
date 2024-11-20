package nextstep.ladder.domain;

import java.util.HashMap;

public class Point {

    private final PointIndex pointIndex;
    private boolean hasPoint;

    public Point(boolean hasPoint, int left) {
        this.hasPoint = hasPoint;
        this.pointIndex = new PointIndex(left);
    }

    public void move(HashMap<Integer, Integer> map) {
        if (hasPoint) {
            pointIndex.swap(map);
        }
    }
}
