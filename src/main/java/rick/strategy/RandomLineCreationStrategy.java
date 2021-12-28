package rick.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import rick.domain.Point;
import rick.domain.Points;

public class RandomLineCreationStrategy implements LineCreationStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public Points create(int countOfPerson) {
        Point firstPoint = new Point(false, RANDOM.nextBoolean());
        List<Point> points = new ArrayList<>(Arrays.asList(firstPoint));

        Point previousPoint = firstPoint;
        for (int i = 1; i < countOfPerson - 1; i++) {
            Point point = previousPoint.next(RANDOM.nextBoolean());
            points.add(point);
            previousPoint = point;
        }

        points.add(previousPoint.last());

        return new Points(points);
    }
}
