package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class Line {

    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public static Line init(int sizeOfPerson) {
        return null;
    }

    public int move(int value) {
        return 0;
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public static Line newInstance(int maxPoint, DirectionPredicate predicate) {
        return new Line(Points.newInstance(maxPoint, predicate));
    }

    public int sizeOfPositions(){
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
