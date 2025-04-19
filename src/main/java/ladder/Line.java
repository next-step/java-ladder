package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int countOfPersons, PointStrategy strategy) {
        List<Point> line = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < countOfPersons - 1; i++) {
            boolean current = !prev && strategy.generate();
            line.add(new Point(current));
            prev = current;
        }
        this.points = line;
    }

    public int move(int index) {
        if (canMoveLeft(index)) return index - 1;
        if (canMoveRight(index)) return index + 1;
        return index;
    }

    public boolean canMoveLeft(int index) {
        return index > 0 && points.get(index - 1).hasRight();
    }

    public boolean canMoveRight(int index) {
        return index < points.size() && points.get(index).hasRight();
    }

    public int size() {
        return points.size();
    }

    public List<Point> points() {
        return List.copyOf(points);
    }

}