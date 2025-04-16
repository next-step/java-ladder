package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public void add(Point point) {
        points.add(point);
    }

    public Point get(int idx) {
        return points.get(idx);
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    public int size() {
        return points.size();
    }

    public boolean canGoLeft(int idx) {
        if (idx == 0) {
            return false;
        }
        return points.get(idx - 1).hasPoint();
    }

    public boolean canGoRight(int idx) {
        if (isLastIdx(idx)) {
            return false;
        }
        return points.get(idx).hasPoint();
    }

    private boolean isLastIdx(int idx) {
        return points.size() == idx;
    }

    public boolean canDrawNext(int idx) {
        return points.get(idx - 1).canDrawNext();
    }

}
