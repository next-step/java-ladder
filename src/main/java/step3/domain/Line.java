package step2.domain;

import javafx.geometry.Pos;

import javax.swing.text.Position;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public Line(int countOfPerson) {
        this.points = createLine(countOfPerson, randomGenerator);
    }

    public Line(List<Point> points) {
        this.points = points;
    }



    public List<Point> createLine(int countOfPerson, PositionGenerator positionGenerator) {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(positionGenerator.generate());
        points.add(first);
        List<Point> body = body(countOfPerson, first);
        points.addAll(body);
        tail(points.get(countOfPerson - 2), points);
        return points;
    }

    private List<Point> body(int countOfPerson, Point first) {
        return IntStream.range(1, countOfPerson-1)
                .mapToObj(i -> first.next())
                .collect(Collectors.toList());
    }

    private void tail(Point point, List<Point> points) {
        points.add(point.last());
    }

    public List<Point> row() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points) && Objects.equals(randomGenerator, line.randomGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, randomGenerator);
    }

    @Override
    public String toString() {
        return "" + points;
    }
}
