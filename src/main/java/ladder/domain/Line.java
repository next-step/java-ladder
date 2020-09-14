package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final int NUMBER_ONE = 1;
    private List<Point> points;

    public Line(int countOfPlayer, RightPointRandom rightPointRandom) {
        this.points = createLine(countOfPlayer, rightPointRandom);
    }

    public List<Point> createLine(int countOfPlayer, RightPointRandom rightPointRandom) {
        points = new ArrayList<>();
        Point point = Point.first(rightPointRandom.right());
        points.add(point);

        for (int i = NUMBER_ONE; i < countOfPlayer - NUMBER_ONE; i++) {
            point = point.next(rightPointRandom.right());
            points.add(i, point);
        }

        points.add(countOfPlayer - NUMBER_ONE, point.last());
        return points;
    }

    public int getSize() {
        return points.size();
    }

    public boolean isLeft(int index) {
        return points.get(index).isLeft();
    }
}