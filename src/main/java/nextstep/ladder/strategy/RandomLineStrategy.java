package nextstep.ladder.strategy;

import nextstep.ladder.doamin.value.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    private static final Random RANDOM = new Random();
    private static final Integer START_POINT_INDEX = 1;
    private static final Integer PREVIOUS_POINT_INDEX = -1;

    @Override
    public List<Point> createPoints(int countOfPerson) {
        List<Point> points = new ArrayList<>(Collections.nCopies(countOfPerson, Point.from(false)));

        IntStream.range(START_POINT_INDEX, countOfPerson)
                .forEach(index -> {
                    Point previousPoint = points.get(index + PREVIOUS_POINT_INDEX);
                    points.set(index, nextPoint(previousPoint));
                });
        return points;
    }

    private Point nextPoint(Point previousPoint) {
        if (previousPoint.isTrue()) {
            return Point.from(false);
        }
        return Point.from(RANDOM.nextBoolean());
    }
}
