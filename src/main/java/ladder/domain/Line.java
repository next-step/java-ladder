package ladder.domain;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    private Line(int height, IntFunction<Point> function) {

        this.points = IntStream.range(0, height)
                .mapToObj(function)
                .collect(Collectors.toList());
    }

    public static Line of(int lineNumber, int height) {

        return new Line(height, step -> Point.of(step, lineNumber));
    }

    public static Line ofLastLine(int height) {

        return new Line(height, step -> Point.of(false));
    }

    public boolean hasPoint(int lineNumber) {

        return points.get(lineNumber) != null && points.get(lineNumber).hasPoint();
    }

}