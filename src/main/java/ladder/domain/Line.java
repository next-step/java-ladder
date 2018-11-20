package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;
    
    public Line() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point nextPoint) {
        validateOverlapLine(nextPoint);
        this.points.add(nextPoint);
    }

    private void validateOverlapLine(Point nextPoint) {
        if (!points.isEmpty() && nextPoint.isOverlap(getLastPoint())) {
            throw new IllegalArgumentException("가로 라인이 겹칩니다.");
        }
    }
    
    public Point getLastPoint() {
        return this.points.get(this.points.size()-1);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int nextDirection(int index) {
        return points.get(index).nextDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(points, line1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}