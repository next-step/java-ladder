package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    public Line(int countOfPerson) {
        points = lineCreate(countOfPerson);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getWidth() {
        return points.size();
    }

    private List<Point> lineCreate(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(randomGenerate());
        points.add(point);

        int i = 0;

        while (countOfPerson - 2 > i) {
            point = point.next(randomGenerate());
            points.add(point);

            i += 1;
        }

        points.add(point.last());

        return Collections.unmodifiableList(points);
    }

    public boolean randomGenerate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
