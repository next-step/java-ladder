package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ladder.utils.RandomPointGenerator;

public class RandomLineGenerator implements LineGenerator {

    @Override
    public Line generate(int countOfPeople) {
        if (countOfPeople == 1) {
            return singlePointLine();
        }
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initMiddle(countOfPeople, points, point);
        initLast(points, point);
        return Line.of(points);
    }

    private Point initMiddle(int countOfPeople, List<Point> points, Point point) {
        while (points.size() < countOfPeople - 1) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private Point initFirst(List<Point> points) {
        Point point = Point.first(RandomPointGenerator.generate());
        points.add(point);
        return point;
    }

    private static Line singlePointLine() {
        Point onlyPoint = Point.first(false);
        return Line.of(Arrays.asList(onlyPoint));
    }
}
