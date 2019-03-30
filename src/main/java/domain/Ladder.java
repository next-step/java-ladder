package domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private Set<Line> lines;
    private Set<Point> points;

    public Ladder(Integer length, Integer height) {
        lines = new HashSet<>();
        points = IntStream.rangeClosed(1, height)
            .boxed()
            .flatMap(x -> IntStream.rangeClosed(1, length).mapToObj(y -> Point.of(x, y)))
            .collect(Collectors.toSet());
    }

    public void init() {
        points.forEach(this::createLine);
    }

    public boolean lineExist(Point point) {
        return lines.stream()
            .anyMatch(l -> l.contains(point));
    }

    public void createLine(Point point) {
        if(!lineExist(point)) {
            Point rightPoint = Point.of(point.getX() + 1, point.getY());
            if(points.contains(rightPoint)) {
                lines.add(new Line(point, rightPoint));
            }
            //        if(true /* && rule.pass() */) {
            //        }
        }

    }

    public Point nextPoint(Point point) {
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

    public Set<Point> getPoints() {
        return points;
    }
}
