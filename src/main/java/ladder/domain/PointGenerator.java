package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public interface PointGenerator {
    int OUT_SIDES = 2;
    double SEED_VALUE = 0.5;

    default List<Point> generate(int countOfPerson) {
        List<Point> points = new ArrayList<>(countOfPerson);
        initPoints(countOfPerson, points);
        return points;
    }

    default void initPoints(int countOfPerson, List<Point> points) {
        points.add(Point.first(getRandomBoolean()));
        IntStream.range(0, countOfPerson - OUT_SIDES)
                .forEach(count -> points.add(points.get(count).next(getRandomBoolean())));
    }

    default boolean getRandomBoolean() {
        return Math.random() < SEED_VALUE;
    }

}
