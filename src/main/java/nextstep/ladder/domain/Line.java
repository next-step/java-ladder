package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line(int countOfPerson, PointFactory pointFactory) {
        this.points = pointFactory.createPoints(countOfPerson);
    }

    @Override
    public String toString() {
        return String.join("", points.stream().map(Point::toString).collect(Collectors.toList()));
    }
}
