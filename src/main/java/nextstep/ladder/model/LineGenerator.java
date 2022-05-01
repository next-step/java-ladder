package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.List;

public final class LineGenerator {

    private final Positive pointCount;
    private final PointPainter painter;

    private LineGenerator(Positive pointCount, PointPainter painter) {
        Assert.notNull(pointCount, "pointCount must not be null");
        Assert.notNull(painter, "painter must not be null");
        this.pointCount = pointCount;
        this.painter = painter;
    }

    public static LineGenerator of(Positive pointCount, PointPainter painter) {
        return new LineGenerator(pointCount, painter);
    }

    Line line() {
        return Line.from(points());
    }

    private List<Point> points() {
        List<Point> points = new ArrayList<>();
        Point point = painter.point();
        points.add(point);
        for (Positive index = Positive.ONE; index.lessThan(pointCount); index = index.add(Positive.ONE)) {
            point = nonOverlappingPoint(point, index.equals(pointCount.minus(Positive.ONE)));
            points.add(point);
        }
        return points;
    }

    private Point nonOverlappingPoint(Point point, boolean isLast) {
        if (point.isConnected() || isLast) {
            return Point.DISCONNECTED;
        }
        return painter.point();
    }
}
