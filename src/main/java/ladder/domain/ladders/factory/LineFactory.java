package ladder.domain.ladders.factory;

import ladder.domain.ladders.ladder.Line;
import ladder.domain.ladders.PointPredicate;

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
