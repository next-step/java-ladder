package nextstep.ladder.domain.ladder;

import java.util.List;

public class Line {

    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public static Line init(int sizeOfPerson, DirectionPredicate predicate) {
        Points points = Points.newInstance(sizeOfPerson, predicate);
        return new Line(points);
    }

    public int move(int position) {
        return points.move(position);
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public int sizeOfPositions() {
        return points.size();
    }
}
