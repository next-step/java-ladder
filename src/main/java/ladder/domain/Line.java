package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Point point = Point.first(new RandomUtil());
        this.points.add(point);

        for (int i = 0; i < countOfPerson - 2; i++) {
            point = point.next(new RandomUtil());
            this.points.add(point);
        }

        this.points.add(point.last());
    }

    public List<Boolean> currentPoints() {
        return points.stream()
                .map(Point::getCurrent)
                .collect(Collectors.toList());
    }
}
