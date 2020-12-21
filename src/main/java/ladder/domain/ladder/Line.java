package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int giveDirection(int rowPoint) {
        return points.get(rowPoint).move();
    }

    public List<Boolean> getPointsRow(){
        return this.points.stream()
                            .map(point -> point.isRight())
                            .collect(Collectors.toList());
    }

    public int sizeWidth() {
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
