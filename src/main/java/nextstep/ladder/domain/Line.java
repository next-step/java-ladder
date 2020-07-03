package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(GeneratePointStrategy strategy) {
        this.points = strategy.generate();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public static Line of(int countOfPerson) {
        return new Line(new RandomPointStrategy(countOfPerson));
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
