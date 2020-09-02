package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.domain.Point.*;
import static nextstep.ladder.utils.CommonConstant.NUMBER_ONE;
import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class Line {

    private List<Point> points;

    public Line(int countOfuser, LadderGenerator ladderGenerator) {
        points = createLine(countOfuser, ladderGenerator);
    }

    private List<Point> createLine(int countOfUser, LadderGenerator ladderGenerator) {
        points = new ArrayList<>();
        Point firstPoint = first(ladderGenerator.right());
        points.add(NUMBER_ZERO, firstPoint);
        int count = countOfUser - NUMBER_ONE;

        for (int i = NUMBER_ONE; i < count; i++) {
            Point nextPoint = next(firstPoint, ladderGenerator.right());
            points.add(i, nextPoint);
            firstPoint = nextPoint;
        }

        Point lastPoint = last(firstPoint.isRight());
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
