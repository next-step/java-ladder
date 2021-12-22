package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomPoints implements PointsStrategy {
    private int number;

    public RandomPoints(int number) {
        this.number = number;
    }

    @Override
    public List<Point> points() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(RandomGenerator.generate());
        points.add(point);

        for (int i = 1; i < number - 1; i++) {
            point = point.nextRandom();
            points.add(point);
        }

        points.add(point.last());
        return points;
    }

}
