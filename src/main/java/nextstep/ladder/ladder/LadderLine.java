package nextstep.ladder.ladder;

import nextstep.ladder.strategy.LadderStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(List<Point> points) {
        return new LadderLine(points);
    }

    public static LadderLine of(int sizeOfPerson, LadderStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(strategy.creatable());
        points.add(point);

        while (point.untilBeforeLastPoint(sizeOfPerson)) {
            point = point.next(strategy);
            points.add(point);
        }

        points.add(point.last());

        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    int size() {
        return points.size();
    }
}
