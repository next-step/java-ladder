package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int SECOND_POINT_INDEX = 1;
    private static final int INDEX_LEFT_SIDE = -1;
    private final List<Point> points = new ArrayList<>();

    public Line(int personCount, BarCreator barCreator) {
        initPoints(personCount, barCreator);
    }

    private void initPoints(int personCount, BarCreator barCreator) {
        points.add(Point.first());
        for (int i = SECOND_POINT_INDEX; i < personCount; i++) {
            points.add(Point.of(getLeftPoint(i), barCreator));
            getLeftPoint(i).setDirection(points.get(i));
        }
    }

    private Point getLeftPoint(int index) {
        return points.get(index + INDEX_LEFT_SIDE);
    }

    public List<String> lineToString() {
        return points.stream()
                     .map(Point::toString)
                     .collect(Collectors.toList());
    }

    public int move(int currentIndex) {
        return currentIndex + points.get(currentIndex).move();
    }
}
