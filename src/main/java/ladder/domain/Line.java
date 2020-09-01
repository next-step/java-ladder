package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int SECOND_POINT_INDEX = 1;
    private static final int INDEX_LEFT_SIDE = -1;
    private static final int INDEX_RIGHT_SIDE = 1;

    private final List<Point> points = new ArrayList<>();

    public Line(int personCount, PointCreator pointCreator) {

        addFirstPoint();

        for (int i = SECOND_POINT_INDEX; i < personCount; i++) {
            points.add(getCurrentPoint(getLeftPoint(i), pointCreator));
        }
    }

    private void addFirstPoint() {
        points.add(Point.FALSE);
    }

    private Point getLeftPoint(int index) {
        return points.get(index + INDEX_LEFT_SIDE);
    }

    private Point getCurrentPoint(Point point, PointCreator pointCreator) {
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
        return hasBar(index);
    }

    private boolean hasRightBar(int index) {
        if (right(index) >= points.size()) {
            return false;
        }
        return hasBar(right(index));
    }

    private boolean hasBar(int index) {
        return points.get(index) == Point.TRUE;
    }

    private int right(int index) {
        return index + INDEX_RIGHT_SIDE;
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
        return currentIndex + INDEX_LEFT_SIDE;
    }

    private int moveRight(int currentIndex) {
        return currentIndex + INDEX_RIGHT_SIDE;
    }
}
