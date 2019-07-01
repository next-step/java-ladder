package ladder.domain;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    private List<Point> points;

    private Points(int height, IntFunction<Point> pointFunction) {

        this.points = IntStream.range(0, height)
                .mapToObj(pointFunction)
                .collect(Collectors.toList());
    }

    public static Points of(int height, int lineNumber) {

        return new Points(height, step -> Point.of(step, lineNumber));
    }

    public static Points of(int height, boolean isPoint) {

        return new Points(height, step -> Point.of(isPoint));
    }

    public boolean isPoint(int lineNumber) {

        Point point = points.get(lineNumber);
        return point != null && point.isPoint();
    }
}
