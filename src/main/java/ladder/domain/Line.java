package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    private static Line init(boolean right) {
        List<Point> points = new ArrayList<>();
        points.add(Point.getFirst(right));

        return Line.of(points);
    }

    public static Line create(Participants participant, LineGenerator lineGenerator) {
        if (participant.isShortage()) {
            return Line.init(false);
        }

        Line line = Line.init(lineGenerator.getRight());
        line.makeNextPoints(participant, lineGenerator);
        return line;
    }

    private void makeNextPoints(Participants participant, LineGenerator lineGenerator) {
        Point firstPoint = getFirst();

        for (int i = 1, size = participant.getNumber(); i < size - 1; i++) {
            Point next = Point.next(firstPoint, lineGenerator.getRight());
            points.add(next);

            firstPoint = next;
        }
        Point last = Point.getLast(firstPoint.isRight());
        points.add(last);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    private Point getFirst() {
        return Optional.ofNullable(points.get(0))
                .orElseGet(() -> Point.of(false, false));
    }
}
