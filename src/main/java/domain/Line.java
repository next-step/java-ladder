package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>(2);

    public Line(Point point1, Point point2) {
        if(point1.distanceOfX(point2) > 1) {
            throw new IllegalArgumentException();
        }

        points.add(point1);
        points.add(point2);
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }

    public Point appositePoint(Point point) {
        return point.equals(points.get(0)) ? points.get(1) : points.get(0);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        if(obj.getClass() == getClass()) {
            Line line = (Line) obj;
            return points.equals(line.points);
        }

        return super.equals(obj);
    }
}
