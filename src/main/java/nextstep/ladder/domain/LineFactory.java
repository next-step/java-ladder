package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LineFactory {

    public static <T> Line of(PointsGenerateStrategy<T> strategy, T pointParam) {
        List<Point> points = Collections.unmodifiableList(strategy.generate(pointParam));
        return new Line(points);
    }

}
