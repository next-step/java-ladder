package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.utils.RandomBoolGenerator.generate;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfParticipants) {
        if (countOfParticipants <= 1) {
            throw new IllegalArgumentException();
        }
        List<Point> points = new ArrayList<>();

        points.add(Point.ofFirstPoint(generate()));
        for (int pos = 1; pos < countOfParticipants - 1; ++pos) {
            Point nextPoint = points.get(pos - 1).getNext();
            points.add(nextPoint);
        }
        boolean nextLeft = points.get(countOfParticipants - 2).getRight();
        points.add(Point.ofLastPoint(nextLeft));

        return new Line(points);
    }

    public static Line of(Participants participants) {
        List<Point> points = new ArrayList<>();

        points.add(Point.ofFirstPoint(generate()));
        while (!participants.isBeforeLast(points.size())) {
            Point nextPoint = points.get(points.size() - 1).getNext();
            points.add(nextPoint);
        }
        boolean nextLeft = points.get(points.size() - 1).getRight();
        points.add(Point.ofLastPoint(nextLeft));

        return new Line(points);
    }

    public Point getPoint(int pos) {
        if (pos >= points.size() || pos < 0) {
            throw new IndexOutOfBoundsException("라인의 범위를 초과하였습니다.");
        }
        return points.get(pos);
    }

    public List<Point> getPoints() {
        return points;
    }
}
