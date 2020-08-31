package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int personCount, PointCreator pointCreator) {

        points.add(Point.FALSE);

        for (int i = 1; i < personCount; i++) {
            points.add(nextPoint(getPrevPoint(i), pointCreator));
        }
    }

    private Point getPrevPoint(int index) {
        return points.get(index - 1);
    }

    private Point nextPoint(Point point, PointCreator pointCreator) {
        if (point == Point.TRUE) {
            return Point.FALSE;
        }
        return Point.of(pointCreator.create());
    }

    public List<String> getPoints() {
        return points.stream()
                .map(Point::getBar)
                .collect(Collectors.toList());
    }

    private boolean hasLeftBar(int index) {
        return points.get(index) == Point.TRUE;
    }

    private boolean hasRightBar(int index) {
        if (index + 1 >= points.size()) {
            return false;
        }
        return points.get(index + 1) == Point.TRUE;
    }

    public int move(int currentIndex) {

        if (hasLeftBar(currentIndex)) {
            return moveLeft(currentIndex);
        }

        if (hasRightBar(currentIndex)) {
            return moveRight(currentIndex);
        }

        return currentIndex;
    }

    private int moveLeft(int currentIndex) {
        return currentIndex - 1;
    }

    private int moveRight(int currentIndex) {
        return currentIndex + 1;
    }
}
