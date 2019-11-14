package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int height() {
        return points.size();
    }

    public Direction getDirectionByHeight(int height) {
        return points.get(height).getDirection();
    }

    public Point getPointByHeight(int height) {
        return points.get(height);
    }
}
