package ladder.domain.Ladder.factory;

import ladder.utils.LambdaUtils;
import ladder.domain.Ladder.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineFactory {

    private static final Random random = ThreadLocalRandom.current();

    private LineFactory() {
    }

    public static List<Point> generatePoints(int countOfPerson) {
        return Stream.iterate(new Point(random.nextBoolean()),
                        previous -> LambdaUtils.decidePointExist(
                                previous,
                                new Point(random.nextBoolean()),
                                Point::isEqualToTrue)
                )
                .limit(countOfPerson - 1L)
                .collect(Collectors.toList());
    }

    public static List<Point> generatePoints(Boolean[] points) {
        return Arrays.stream(points).map(Point::new).collect(Collectors.toList());
    }
}
