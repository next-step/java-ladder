package ladder.domain;

import ladder.domain.util.CrossGenerator;
import ladder.exception.PlayersCountException;
import ladder.exception.PointException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int endExclusive = playersCount - END_EXCLUSIVE_OFFSET;
        Point first = Point.first(generator.generate());
        return IntStream.range(START_INCLUSIVE, endExclusive)
                .boxed()
                .map(index -> toPoint(index, first, generator, endExclusive))
                .collect(Collectors.toList());
    }

    private static Point toPoint(int index, Point point, CrossGenerator lineGenerator, int endExclusive) {
        try {
            if (index == START_INCLUSIVE) {
                return point;
            }
            if (index == endExclusive) {
                return point.last();
            }
            return point.next(lineGenerator.generate());
        } catch (PointException e) {
            return toPoint(index, point, lineGenerator, endExclusive);
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