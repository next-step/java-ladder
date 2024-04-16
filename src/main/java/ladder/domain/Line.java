package ladder.domain;

import java.util.List;

// 사다리의 가로 선
public class Line {
    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(int countOfPlayer) {
        this.points = new Points(countOfPlayer);
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public Boolean hasPoint(int index) {
        Point point = points.getPointOrNull(index);
        if (point == null) return false;
        return point.exist();
    }
}
