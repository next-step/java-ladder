package ladder.domain.generator;

import ladder.domain.Line;
import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line generate(int countOfPerson) {
        List<Point> points = new ArrayList<>(countOfPerson);
        initFirst(countOfPerson, points);
        initBody(countOfPerson, points);
        initLast(countOfPerson, points);
        return new Line(points);
    }

    private void initFirst(int countOfPerson, List<Point> points) {
        if (countOfPerson > 0)
            points.add(Point.getFirst());
    }

    private void initBody(int countOfPerson, List<Point> points) {
        Point current = points.get(0);
        for (int i = 1; i < countOfPerson - 1; i++) {
            current = Point.valueOf(current);
            points.add(current);
        }
    }

    private void initLast(int countOfPerson, List<Point> points) {
        if (countOfPerson > 2) {
            Point secondFromLast = points.get(points.size() - 1);
            points.add(Point.getLast(secondFromLast));
        }
    }
}
