package ladder.domain.Ladder.factory;

import ladder.domain.Ladder.Line;
import ladder.domain.Ladder.PointPredicate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineFactory {

    private LineFactory() {
    }

    public static List<Line> generateLines(int height, int countOfPerson, PointPredicate pointPredicate) {
        return Stream.generate(() -> new Line(countOfPerson, pointPredicate))
                .limit(height)
                .collect(Collectors.toList());
    }
}
