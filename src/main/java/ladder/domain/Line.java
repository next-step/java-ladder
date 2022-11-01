package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        List<Point> points = new ArrayList<>();

        points.add(new Point());
        for (int i = 1; i < countOfPerson; i++) {
            points.add(points.get(i - 1).nextPoint());
        }

        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean canMoveRight(int idx) {
        if (idx >= points.size()) {
            return false;
        }

        Point point = points.get(idx);
        return point.isExist();
    }

    public boolean canMoveLeft(int idx) {
        if (idx - 1 < 0) {
            return false;
        }

        Point leftPoint = points.get(idx - 1);
        if (leftPoint.isExist()) {
            return true;
        }
        return false;
    }
}
