package ladder.domain.ladders.factory;

import ladder.domain.ladders.ladder.Line;
import ladder.domain.ladders.ladder.Point;
import ladder.domain.ladders.PointPredicate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointFactory {

    private PointFactory() {
    }

    public static List<Point> generatePoints2(int countOfPerson, PointPredicate predicate) {
        return create(getPredicatedValues(countOfPerson, predicate));
    }

    public static List<Point> generatePoints2(Boolean[] exists) {
        return create(Arrays.asList(exists));
    }

    private static List<Boolean> getPredicatedValues(int countOfPerson, PointPredicate predicate) {
        return Stream.generate(predicate::exists)
                .limit(countOfPerson - 1L)
                .collect(Collectors.toList());
    }

    private static List<Point> create(List<Boolean> exists) {
        Deque<Point> points = new ArrayDeque<>();
        points.push(Point.first(exists.get(0)));

        for (int i = 1; i < exists.size(); i++) {
            points.addLast(points.getLast().next(exists.get(i)));
        }

        points.add(points.getLast().last());
        return new ArrayList<>(points);
    }
}
