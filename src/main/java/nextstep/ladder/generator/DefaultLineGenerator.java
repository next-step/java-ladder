package nextstep.ladder.generator;

import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DefaultLineGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public List<Point> createLine(final int countOfPerson) {

        List<Point> points = new ArrayList<>(Arrays.asList(Point.initFalse()));
        IntStream.rangeClosed(1, countOfPerson - 1)
                .forEach(value -> points.add(point()));

        return points;
    }

    private Point point() {
        return Point.of(RANDOM.nextBoolean());
    }
}
