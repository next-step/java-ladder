package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(int countOfPeople) {
        points = new ArrayList<>();

        IntStream.range(1, countOfPeople)
                .forEach(num -> points.add(createPoint()));
    }

    private Point createPoint() {
        if (points.isEmpty()) {
            return new Point();
        }

        return new Point(points.get(points.size() - 1));
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
