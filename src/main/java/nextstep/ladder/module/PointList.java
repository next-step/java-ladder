package nextstep.ladder.module;

import java.util.ArrayList;
import java.util.List;

public class PointList implements Iterable<Point> {
    private final List<Point> points;

    public PointList(int i) {
        points = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            points.add(new Point(j));
        }
    }

    public List<Point> points() {
        return points;
    }
    
    public Point get(int i) {
        return points.get(i);
    }

    public int size() {
        return points.size();
    }

    @Override
    public java.util.Iterator<Point> iterator() {
        return points.iterator();
    }
}
