package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line make(int participantsCount) {
        List<Point> points = new ArrayList<>();
        StepFactory stepFactory = StepFactory.first();
        Point point = Point.first(stepFactory.current());
        points.add(point);
        for (int index = 1; index < participantsCount - 1; index++) {
            point = point.next(stepFactory.next());
            points.add(point);
        }
        points.add(point.last());
        return new Line(points);
    }

    public int moving(int position) {
        return position + points.get(position).moving();
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(points);
    }
}
