package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ONE;
import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class Line {

    private List<Point> points;

    public Line(int countOfuser, RightPointStrategy ladderGenerator) {
        points = createLine(countOfuser, ladderGenerator);
    }

    private List<Point> createLine(int countOfUser, RightPointStrategy ladderGenerator) {
        points = new ArrayList<>();
        Point firstPoint = Point.first(ladderGenerator.right());
        points.add(NUMBER_ZERO, firstPoint);
        int count = countOfUser - NUMBER_ONE;

        for (int i = NUMBER_ONE; i < count; i++) {
            Point nextPoint = Point.next(firstPoint, ladderGenerator.right());
            points.add(i, nextPoint);
            firstPoint = nextPoint;
        }

        Point lastPoint = Point.last(firstPoint.isRight());
        points.add(count, lastPoint);
        return points;
    }

    public int size() {
        return points.size();
    }

    public Point getPointIndex(int index) {
        return points.get(index);
    }

}
