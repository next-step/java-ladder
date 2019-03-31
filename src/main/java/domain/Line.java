package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>(2);

    private Line(Point point1, Point point2) {
        if(point1.distanceOfX(point2) > 1) {
            throw new IllegalArgumentException();
        }

        points.add(point1);
        points.add(point2);
    }

    public static Line valueOf(Point point1, Point point2) {
        return new Line(point1, point2);
    }

    public static Line create(Point point) {
        return Line.valueOf(point, point.increaseX());
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }

    public Point appositePoint(Point currentPoint) {
        return currentPoint.equals(points.get(0)) ? points.get(1) : points.get(0);
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

    @Override
    public int hashCode() {
        return points.stream().mapToInt(p -> p.getX() + p.getY()).sum();
    }
}
