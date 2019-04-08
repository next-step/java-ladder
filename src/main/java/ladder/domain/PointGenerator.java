package ladder.domain;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@ToString
public class PointGenerator {

    public static final int OUT_SIDES = 2;
    public static final double SEED_VALUE = 0.5;

    public List<Point> generate(int countOfPerson) {
        List<Point> points = new ArrayList<>(countOfPerson);
        initPoints(countOfPerson, points);
        validatePoint(points);
        return points;
    }

    private void initPoints(int countOfPerson, List<Point> points) {
        points.add(Point.first(getRandomBoolean()));
        IntStream.range(0, countOfPerson - OUT_SIDES)
                .forEach(count -> points.add(points.get(count).next(getRandomBoolean())));
    }

    void validatePoint(List<Point> points) {
        points.forEach(point -> {
            point.validation();
        });
    }

    public boolean getRandomBoolean() {
        return Math.random() < SEED_VALUE;
    }

}
