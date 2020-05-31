package nextstep.ladder.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.line.LinePoints;
import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.PointGenerator;

public class LinePointFactory {

    public static LinePoints of(int countOfPerson, PointGenerator pointGenerator) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("count of person must be more than one");
        }

        List<Point> points = new ArrayList<>(Arrays.asList(Point.first(pointGenerator)));

        for (int i = 1; i < countOfPerson - 1; i++) {
            Point pre = points.get(i - 1);
            points.add(pre.next(pointGenerator));
        }

        return new LinePoints(points);
    }
}
