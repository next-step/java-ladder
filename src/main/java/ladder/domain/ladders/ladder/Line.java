package ladder.domain.ladders.ladder;

import ladder.domain.ladders.PointPredicate;
import ladder.domain.ladders.factory.PointFactory;
import ladder.domain.participants.Position;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    public Line(int countOfPerson, PointPredicate pointPredicate) {
        this(PointFactory.generatePoints2(countOfPerson, pointPredicate));
    }

    public Line(Boolean... points) {
        this(PointFactory.generatePoints2(points));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return this.points.stream()
                .map(Point::isLeft)
                .collect(Collectors.toUnmodifiableList());
    }

    public Position move(Position position) {
        return position.find(this.points).move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
