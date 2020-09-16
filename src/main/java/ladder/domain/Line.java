package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(int userCount, PointStrategy pointStrategy) {
        points = createLine(userCount, pointStrategy);
    }

    private List<Point> createLine(int userCount, PointStrategy pointStrategy) {
        points = new ArrayList<>();
        Point presentPoint = Point.first(pointStrategy.next());
        points.add(0, presentPoint);

        for (int index = 1; index < userCount - 1; index++) {
            Point next = Point.next(presentPoint, pointStrategy.next());
            points.add(index, next);
            presentPoint = next;
        }
        Point lastPoint = Point.last(presentPoint.isRight());
        points.add(userCount - 1, lastPoint);
        return points;
    }

    public int size() {
        return points.size();
    }

    public Point getIndex(int index) {
        return points.get(index);
    }
}
