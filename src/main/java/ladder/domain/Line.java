package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.util.RandomUtil.randomBoolean;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Point point = Point.first(randomBoolean());
        this.points.add(point);

        for (int i = 0; i < countOfPerson - 2; i++) {
            point = point.next(randomBoolean());
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
