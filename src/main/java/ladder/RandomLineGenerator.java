package ladder;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line generate(int countOfPerson) {
        List<Point> points = new ArrayList<>(countOfPerson);
        setLine(countOfPerson, points);
        return new Line(points);
    }

    private void setLine(int countOfPerson, List<Point> points) {
        Point previous = null;
        for (int i = 0; i < countOfPerson - 1; i++) {
            Point current = Point.valueOf(previous);
            points.add(current);
            previous = current;
        }
        points.add(Point.getRightNotLinked(previous));
    }
}
