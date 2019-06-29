package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(int lineNumber, int heights) {

        this.points = IntStream.range(0, heights)
                .mapToObj(step -> Point.of(step, lineNumber))
                .collect(Collectors.toList());
    }

    public Line(int heights) {

        this.points = IntStream.range(0, heights)
                .mapToObj(i -> Point.of(false))
                .collect(Collectors.toList());
    }

    public boolean hasPoint(int lineNumber) {

        return points.get(lineNumber) != null && points.get(lineNumber).isPoint();
    }

}