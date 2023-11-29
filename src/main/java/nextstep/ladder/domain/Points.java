package nextstep.ladder.domain;

import java.util.List;

public class Points {
    private List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public int move(int currentPoint) {
        return points.get(currentPoint).move();
    }
}
