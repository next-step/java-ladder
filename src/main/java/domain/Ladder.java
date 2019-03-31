package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ladder {
    private Set<Point> points;
    private Set<Line> lines = new HashSet<>();

    public Ladder(List<Point> points, List<Point> drewPoint) {
        this.points = new HashSet<>(points);
        this.points.stream()
            .filter(this::canAdd)
            .filter(drewPoint::contains)
            .map(Line::create)
            .forEach(lines::add);
    }

    private boolean canAdd(Point point) {
        return lines.stream().noneMatch(l -> l.contains(point)) && points.contains(point.increaseX());
    }

    public Point findLast(Point point) {
        if(!point.getY().equals(1)) {
            throw new IllegalArgumentException();
        }

        while (points.contains(point)) {
            point = nextPoint(point);
        }

        return Point.valueOf(point.getX(), point.getY() - 1);
    }

    private Point nextPoint(Point point) {
        Optional<Line> optionalLine = lines.stream()
            .filter(l -> l.contains(point))
            .findFirst();

        if(optionalLine.isPresent()) {
            Line line = optionalLine.get();
            Point oppositePoint = line.appositePoint(point);
            return oppositePoint.increaseY();
        }

        return point.increaseY();
    }

    public Set<Line> getLines() {
        return lines;
    }

    public List<Point> getPoints() {
        return points.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public Integer getWidth() {
        return (int) points.stream()
            .filter(p -> p.getY().equals(1))
            .count();
    }

    public Integer getHeight() {
        return (int) points.stream()
            .filter(p -> p.getX().equals(1))
            .count();
    }
}
