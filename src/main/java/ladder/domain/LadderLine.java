package ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    @Getter
    private List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int getSize() {
        return points.size();
    }

    public static LadderLine of(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();

        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);

        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(PointGenerator.generateDirection());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1, end = sizeOfPerson - 1; i < end; i++) {
            point = point.next();
            points.add(point);
        }

        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }
}
