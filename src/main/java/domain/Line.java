package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(int countOfPerson, LadderLevel ladderLevel) {
        this.points = createPoints(countOfPerson, ladderLevel);
    }

    public static Line of(int countOfPerson, LadderLevel ladderLevel) {
        return new Line(countOfPerson, ladderLevel);
    }

    private List<Point> createPoints(int length, LadderLevel ladderLevel) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(ladderLevel.random()));
        for (int i = 1; i < length - 1; i++) {
            points.add(points.get(i - 1).next(ladderLevel));
        }
        points.add(points.get(points.size() - 1).last());

        return points;
    }

    public int getPersonSize() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public int nextPointIndex(int index) {
        return points.get(index).move();
    }
}
