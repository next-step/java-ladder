package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line(int countOfPlayer, PointFactory pointFactory) {
        this.points = pointFactory.createPoints(countOfPlayer);
    }

    @Override
    public String toString() {
        return String.join("", points.stream().map(Point::toString).collect(Collectors.toList()));
    }
}
