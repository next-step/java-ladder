package ladder.domain;

import ladder.domain.util.CrossGenerator;
import ladder.exception.PlayersCountException;
import ladder.exception.PointException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    public static final String NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE = "참여자명 수는 최소 1명 이상이어야 합니다";
    public static final int START_INCLUSIVE = 0;
    public static final int END_EXCLUSIVE_OFFSET = 1;
    public static final int MIN_PLAYERS_COUNT = 1;
    private final List<Point> points;

    public Line(int playersCount, CrossGenerator generator) {
        this(generateLine(playersCount, generator));
    }

    public Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    private static List<Point> generateLine(int playersCount, CrossGenerator generator) {
        if (playersCount < MIN_PLAYERS_COUNT) {
            throw new PlayersCountException(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);
        }

        List<Point> points = new ArrayList<>();
        Point point = Point.first(generator.generate());

        for (int index = START_INCLUSIVE; index < playersCount; index++) {
            int endExclusive = playersCount - END_EXCLUSIVE_OFFSET;
            point = toPoint(index, point, generator, endExclusive);
            points.add(point);
        }

        return points;
    }

    private static Point toPoint(int index, Point previousPoint, CrossGenerator generator, int endExclusive) {
        if (index == START_INCLUSIVE) {
            return previousPoint;
        }

        if (index == endExclusive) {
            return previousPoint.last();
        }

        try {
            return previousPoint.next(generator.generate());
        } catch (PointException e) {
            return toPoint(index, previousPoint, generator, endExclusive);
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(points, line1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "\nLine{" +
                "points=" + points +
                '}';
    }
}