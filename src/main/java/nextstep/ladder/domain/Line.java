package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(int countOfPerson, BooleanStrategy booleanStrategy) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i > 0 && points.get(i - 1).value()) {
                points.add(Point.from(false));
                continue;
            }
            points.add(Point.from(booleanStrategy.value()));
        }
        return new Line(points);
    }

    public List<Point> points() {
        return points;
    }
}
