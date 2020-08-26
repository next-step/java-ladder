package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineRandomGenerator {
    private static final Random random = new Random();

    private Participants participant;

    public LineRandomGenerator(Participants participant) {
        this.participant = participant;
    }

    private boolean getRandomRight() {
        return random.nextBoolean();
    }

    public Line create() {
        if (participant.isShortage()) {
            return Line.init(false);
        }

        List<Point> points = makeRandomPoints();
        return Line.of(points);
    }

    private List<Point> makeRandomPoints() {
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.getFirst(getRandomRight());
        points.add(firstPoint);
        points.addAll(makeNextPoints(firstPoint));

        return points;
    }

    private List<Point> makeNextPoints(Point firstPoint) {
        List<Point> nextPoints = new ArrayList<>();

        for (int i = 1, size = participant.getNumber(); i < size - 1; i++) {
            Point next = Point.next(firstPoint, getRandomRight());
            nextPoints.add(next);

            firstPoint = next;
        }
        Point last = Point.getLast(firstPoint.isRight());
        nextPoints.add(last);

        return nextPoints;
    }

}
