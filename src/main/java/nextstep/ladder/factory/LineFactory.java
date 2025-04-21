package nextstep.ladder.factory;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Point;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private final PointFactory pointFactory;

    public LineFactory() {
        this(new PointFactory());
    }

    public LineFactory(PointFactory pointFactory) {
        this.pointFactory = pointFactory;
    }

    public Line create(int size) {
        List<Point> points = new ArrayList<>();
        Point previousPoint = pointFactory.first();
        points.add(previousPoint);

        for (int i = 1; i < size - 1; i++) {
            Point newPoint = pointFactory.next(previousPoint);
            points.add(newPoint);
            previousPoint = newPoint;
        }

        return new Line(points);
    }
}
