package ladder.domain.Ladder.factory;

import ladder.domain.Ladder.Point;
import ladder.domain.Ladder.PointPredicate;
import ladder.utils.LambdaUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointFactory {

    private PointFactory() {
    }

    public static List<Point> generatePoints(int countOfPerson, PointPredicate predicate) {
        return Stream.iterate(new Point(predicate),
                        previous -> LambdaUtils.decidePointExist(
                                previous,
                                new Point(predicate),
                                Point::isEqualToTrue)
                )
                .limit(countOfPerson - 1L)
                .collect(Collectors.toList());
    }

    public static List<Point> generatePoints(Boolean[] points) {
        return Arrays.stream(points)
                .map(Point::new)
                .collect(Collectors.toList());
    }
}
