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
        if (count < 2) {
            throw new IllegalArgumentException("포인트 수는 2개 이상이어야 합니다.");
        }

        this.points = createPoints(count, lineGenerator);
    }

    private List<Point> createPoints(int count, LineGenerator lineGenerator) {
        List<Point> points = Stream.iterate(Point.first(lineGenerator.draw()),
                                            currentPoint -> currentPoint.next(lineGenerator.draw()))
                                   .limit(count - 1)
                                   .collect(Collectors.toList());

        Point prevPoint = points.get(points.size() - 1);
        points.add(getLastPoint(prevPoint));

        return points;
    }

    private Point getLastPoint(Point prevPoint) {
        return prevPoint.last();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
