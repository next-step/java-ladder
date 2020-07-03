package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointStrategy implements GeneratePointStrategy {

    private final int countOfPerson;

    private static final Random random = new Random();

    public RandomPointStrategy(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    @Override
    public List<Point> generate() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(random.nextBoolean());

        points.add(point);

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(random.nextBoolean());
            points.add(point);
        }

        points.add(point.last());

        return points;
    }
}
