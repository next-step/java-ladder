package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    private static Line init(boolean right) {
        List<Point> points = new ArrayList<>();
        points.add(Point.getFirst(right));

        return new Line(points);
    }

    public static Line create(Participants participant, LineGenerator lineGenerator) {
        if (participant.isShortage()) {
            return Line.init(false);
        }

        List<Point> points = new ArrayList<>();
        Point point = init(points, lineGenerator.getRight());
        makeNextPoints(points, point, lineGenerator, participant.getNumber());

        return new Line(points);
    }

    private static Point init(List<Point> points, boolean right) {
        Point point = Point.getFirst(right);
        points.add(point);

        return point;
    }

    private static void makeNextPoints(List<Point> points, Point point,
                                       LineGenerator lineGenerator, int participantNumber) {
        for (int i = 1; i < participantNumber - 1; i++) {
            point = point.next(lineGenerator.getRight());
            points.add(point);
        }

        Point last = Point.getLast(participantNumber - 1, point.isRight());
        points.add(last);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    public int calculateNextIndex(int index) {
        return points.get(index).move();
    }
}
