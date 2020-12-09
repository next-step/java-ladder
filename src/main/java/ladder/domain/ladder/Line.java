package ladder.domain.ladder;

import ladder.domain.util.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    public static final int NUMBER_ONE = 1;

    private List<Point> points;

    public Line(int countOfPlayer, RandomStrategy randomStrategy) {
        this.points = createLine(countOfPlayer, randomStrategy);
    }

    private List<Point> createLine(int countOfPlayer, RandomStrategy randomStrategy) {
        points = new ArrayList<>();
        Point point = Point.first(randomStrategy.right());
        points.add(point);

        for (int i = NUMBER_ONE; i < countOfPlayer - NUMBER_ONE; i++) {
            point = point.next(randomStrategy.right());
            points.add(i, point);
        }

        points.add(countOfPlayer - NUMBER_ONE, point.last());
        return points;
    }

    public int getSize() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int movePoint(int index) {
        return points.get(index)
                .move();
    }
}
