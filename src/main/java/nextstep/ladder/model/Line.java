package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;
import nextstep.ladder.util.RandomBoolean;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Line {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MINIMUM_ROW_LENGTH = 2;
    private static final Point FALSE = Point.of(false);
    private static final String MINIMUM_LINE_MESSAGE = "사다리 높이는 최소 2개 이상이어야 합니다.";

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    private static void isMinimum(int countOfPeople) {
        Optional.of(countOfPeople)
                .filter(count -> MINIMUM_ROW_LENGTH < count)
                .orElseThrow(() -> new MinimumException(MINIMUM_LINE_MESSAGE));
    }

    private static Function<Integer, List<Point>> init() {
        return countOfPeople -> IntStream
                .range(ZERO, countOfPeople)
                .mapToObj(i -> RandomBoolean.trueOrFalse())
                .map(Point::of)
                .collect(Collectors.toList());
    }

    private static IntPredicate isAdjacentPointsHaveLines(List<Point> points) {
        return index -> points.get(index).value() && points.get(index + ONE).value();
    }

    private static IntConsumer setNextPointNoLine(List<Point> points) {
        return index -> points.set(index + ONE, FALSE);
    }

    private static UnaryOperator<List<Point>> removable() {
        return points -> {
            int lastIndex = points.size() - ONE;
            IntStream.range(ZERO, lastIndex)
                    .filter(isAdjacentPointsHaveLines(points))
                    .forEach(setNextPointNoLine(points));
            points.set(lastIndex, FALSE);
            return points;
        };
    }

    public static Line create(int countOfPeople) {
        isMinimum(countOfPeople);
        List<Point> points = init()
                .andThen(removable())
                .apply(countOfPeople);
        return new Line(points);
    }

    public static List<Line> create(int countOfPeople, int maxHeight) {
        return IntStream
                .range(ZERO, maxHeight)
                .mapToObj(i -> Line.create(countOfPeople))
                .collect(Collectors.toList());
    }

    public Point[] points() {
        return this.points.toArray(Point[]::new);
    }
}
