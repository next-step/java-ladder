package nextstep.ladder.domain.line;

import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.Position;
import nextstep.ladder.domain.point.RightPointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ONE;
import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class LadderLine {

    private List<Point> points;

    public LadderLine(int countOfuser, RightPointStrategy rightPointStrategy) {
        points = init(countOfuser, rightPointStrategy);
    }

    private List<Point> init(int countOfUser, RightPointStrategy rightPointStrategy) {
        points = new ArrayList<>();
        int count = countOfUser - NUMBER_ONE;
        Point point = initFirst(rightPointStrategy);
        point = initBody(count, point, rightPointStrategy);
        initLast(count, point);
        return points;
    }

    public Point initFirst(RightPointStrategy rightPointStrategy) {
        Point firstPoint = Point.first(rightPointStrategy.right());
        points.add(NUMBER_ZERO, firstPoint);
        return firstPoint;
    }

    public Point initBody(int count, Point point, RightPointStrategy rightPointStrategy) {
        int firstLadderPoint = NUMBER_ONE;
        for (int i = firstLadderPoint; i < count; i++) {
            Point nextPoint = Point.next(point, rightPointStrategy.right());
            points.add(i, nextPoint);
            point = nextPoint;
        }
        return point;
    }

    public void initLast(int count, Point point) {
        Point lastPoint = Point.last(point.isRight());
        points.add(count, lastPoint);
    }

    public int ladderPlayCondition(int position) {
        return Position.valueOf(points, position)
                .move(position);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public Point getPointIndex(int index) {
        return points.get(index);
    }

}
