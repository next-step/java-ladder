package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PointGenerator {

    private static final int START_IDX = 1;

    private static List<Point> points;

    private PointGenerator() {
    }

    public static List<Point> generate(int countOfPerson) {
        points = new ArrayList<>();
        points.add(createFirstPoint(() -> new Random().nextBoolean()));
        for (int idx = START_IDX; idx < countOfPerson - 1; idx++) {
            points.add(createPoint(idx, () -> new Random().nextBoolean()));
        }
        points.add(createLastPoint(countOfPerson, () -> new Random().nextBoolean()));
        return Collections.unmodifiableList(points);
    }

    private static Point createLastPoint(int countOfPerson, ConnectStrategy connectStrategy) {
        if (points.get(countOfPerson - 2).connectable() && connectStrategy.connectable()) {
            return new Point(true);
        }
        return new Point(false);
    }

    private static Point createFirstPoint(ConnectStrategy connectStrategy) {
        if (connectStrategy.connectable()) {
            return new Point(true);
        }
        return new Point(false);
    }

    private static Point createPoint(int idx, ConnectStrategy connectStrategy) {
        if (points.get(idx - 1).connectable() && connectStrategy.connectable()) {
            return new Point(true);
        }
        return new Point(false);
    }
}
