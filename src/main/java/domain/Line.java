package domain;

import util.GenerateLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public int move(final int step) {
        return this.points.get(step).move();
    }

    public static Line fromFirst(final int countOfPlayer, final GenerateLine generateLine) {
        final List<Point> points = new ArrayList<>();
        for (int i = 0; i < countOfPlayer; i++) {
            points.add(generateLine.fromRandom());
        }
        return new Line(points);
    }

    public static Line fromMiddle(final int countOfPlayer, final Line line, final GenerateLine generateLine) {
        final List<Point> points = new ArrayList<>();
        for (int i = 0; i < countOfPlayer; i++) {
            points.add(generateLine.fromMiddle(line, i));
        }
        return new Line(points);
    }

    public static Line fromLast(final int countOfPlayer, final GenerateLine generateLine) {
        final List<Point> points = new ArrayList<>();
        for (int i = 0; i < countOfPlayer; i++) {
            points.add(generateLine.fromLast());
        }
        return new Line(points);
    }

    public boolean isExistence(final int sequence) {
        return finaByPointsSequence(sequence).isExistence();
    }

    public List<Point> getPoints() {
        return points;
    }

    private Point finaByPointsSequence(final int sequence) {
        return Optional.ofNullable(this.points.get(sequence)).orElseThrow(Line::lineSequenceDoseNotExistException);
    }

    private static RuntimeException lineSequenceDoseNotExistException() {
        throw new IllegalArgumentException("Line Sequence Does Not Exist. Please check the line number.");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Line{");
        sb.append("points=").append(points);
        sb.append('}');
        return sb.toString();
    }

}
