package nextstep.ladder.domain.line.point;

import nextstep.ladder.domain.line.LineGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public Points(int count, LineGenerator lineGenerator) {
        this.points = createPoints(count, lineGenerator);
    }

    private List<Point> createPoints(int count, LineGenerator lineGenerator) {
        return Stream.iterate(Point.first(lineGenerator.draw()),
                              currentPoint -> currentPoint.next(lineGenerator.draw()))
                     .limit(count)
                     .collect(Collectors.toList());
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
