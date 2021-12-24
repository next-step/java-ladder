package rick.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import rick.domain.Point;

public class RandomLineCreationStrategy implements LineCreationStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public List<Point> create(int countOfPerson) {

        Point previousPoint = new Point(RANDOM.nextBoolean());
        List<Point> points = new ArrayList<>(Arrays.asList(previousPoint));
        
        for (int i = 1; i < countOfPerson; i++) {
            Point point = generateNextPoint(previousPoint);
            points.add(point);
            previousPoint = point;
        }

        return points;
    }

    private Point generateNextPoint(Point previousPoint) {
        if (previousPoint.movable()) {
            return new Point(false);
        }

        return new Point(RANDOM.nextBoolean());
    }
}
