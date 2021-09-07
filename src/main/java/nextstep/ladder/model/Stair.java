package nextstep.ladder.model;

import nextstep.ladder.LadderGameMakeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stair {
    private List<Point> points;

    private Stair(List<Point> points) {
        this.points = points;
    }

    public static Stair of(int numberOfPeople) {
        List<Point> pointList = new ArrayList<>();
        Point point = Point.first(LadderGameMakeUtil.randomValue());

        pointList.add(point);

        for (int i = 1; i < numberOfPeople - 1; i++) {
            point = point.next();
            pointList.add(point);
        }

        pointList.add(point.last());

        return new Stair(pointList);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
