package ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.util.RandomBooleanGenerator;

public class RowGenerator {

    public RowGenerator() {
    }

    public Row create(int countOfPeople) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(points, point, countOfPeople);
        initLast(points, point);

        return new Row(points);
    }

    private Point initFirst(List<Point> points) {
        Point point = Point.first(RandomBooleanGenerator.generator());
        points.add(point);
        return point;
    }

    private Point initBody(List<Point> points, Point point, int countOfPeople) {
        for (int i = 1; i < countOfPeople - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }
    private void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }
}
