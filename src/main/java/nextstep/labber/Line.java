package nextstep.labber;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int LINE_ADD_DEFAULT_VALUE = 2;

    private List<Point> points = new ArrayList<>();

    public Line(int sizeOfParticipants) {
        Point point = Point.first();
        points.add(point);
        for (int i = 0; i < sizeOfParticipants - LINE_ADD_DEFAULT_VALUE; i++) {
           point = point.next();
           points.add(point);
        }
        points.add(point.last());
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public Compass move(int index) {
        return this.points.get(index).move();
    }

    public int size() {
        return this.points.size();
    }

    @Override
    public String toString() {
        return this.points.toString();
    }
}
