package ladder.domain;


import ladder.strategy.MoveStratege;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int FIRST_AND_LAST_COUNT = 2;
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getUnmodifiableListPoints() {
        return Collections.unmodifiableList(points);
    }

    public static Line generatePoints(int countOfUser, MoveStratege moveStrategy) {
        List<Point> userPoints = new ArrayList<>();
        Point point = Point.init(moveStrategy);

        userPoints.add(point);

        for (int index = 0; index < countOfUser - FIRST_AND_LAST_COUNT; index++) {
            point = point.createNextPoint(moveStrategy);
            userPoints.add(point);
        }

        userPoints.add(point.createLastPoint());

        return new Line(userPoints);
    }
}
