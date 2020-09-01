package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ONE;
import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class Line {

    private List<Point> points;

    public Line() {
    }

    public Line(int countOfuser, Point point, LadderGenerator ladderGenerator) {
        points = createLine(countOfuser, point, ladderGenerator);
    }

    private List<Point> createLine(int countOfUser, Point point, LadderGenerator ladderGenerator) {
        points = new ArrayList<>();
        Point firstPoint = point.isFirst(ladderGenerator.right());
        points.add(NUMBER_ZERO, firstPoint);
        int count = countOfUser - NUMBER_ONE;

        for (int i = NUMBER_ONE; i < count; i++) {
            Point otherPoint = point.next(point, ladderGenerator.right());
            points.add(i, otherPoint);
        }

        Point lastPoint = point.isLast(ladderGenerator.right());
        points.add(count, lastPoint);
        return points;
    }

    public int size() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
