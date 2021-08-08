package nextstep.ladder.ladder;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.util.RandomValueGenerator.generate;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generate());
        points.add(point);

        while (point.untilBeforeLastPoint(sizeOfPerson)) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    int size() {
        return points.size();
    }
}
