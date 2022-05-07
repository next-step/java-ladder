package nextstep.step4.factory;

import nextstep.step4.domain.Point;

import java.util.List;

public abstract class Factory {

    public final List<Point> create(int countOfPlayer) {
        Point currentPoint = drawFirstPoint();
        currentPoint = drawMiddlePoints(countOfPlayer, currentPoint);
        return drawLastPoint(currentPoint);
    }

    protected abstract Point drawFirstPoint();

    protected abstract Point drawMiddlePoints(int countOfPlayer, Point currentPoint);

    protected abstract List<Point> drawLastPoint(Point currentPoint);
}
