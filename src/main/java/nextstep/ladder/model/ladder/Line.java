package nextstep.ladder.model.ladder;

import nextstep.ladder.exception.MinimumException;
import nextstep.ladder.util.RandomBoolean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.model.ConstantNumber.*;

public final class Line {

    private static final Point FALSE = Point.of(false);
    private static final String MINIMUM_LINE_MESSAGE = "사다리 높이는 최소 2 이상이어야 합니다.";

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    private static void isMinimum(int countOfPeople) {
        Optional.of(countOfPeople)
                .filter(count -> TWO.getValue() <= count)
                .orElseThrow(() -> new MinimumException(MINIMUM_LINE_MESSAGE));
    }

    private static Function<Integer, List<Point>> init() {
        return countOfPeople -> IntStream
                .range(ZERO.getValue(), countOfPeople)
                .mapToObj(i -> RandomBoolean.trueOrFalse())
                .map(Point::of)
                .collect(Collectors.toList());
    }

    private static IntPredicate isAdjacentPointsHaveLines(List<Point> points) {
        return column -> points.get(column).value() && points.get(column + ONE.getValue()).value();
    }

    private static IntConsumer setNextPointNoLine(List<Point> points) {
        return column -> points.set(column + ONE.getValue(), FALSE);
    }

    private static UnaryOperator<List<Point>> removable() {
        return points -> {
            int lastColumn = points.size() - ONE.getValue();
            IntStream.range(ZERO.getValue(), lastColumn)
                    .filter(isAdjacentPointsHaveLines(points))
                    .forEach(setNextPointNoLine(points));
            points.set(lastColumn, FALSE);
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

    public static Line create(Point... points) {
        isMinimum(points.length);
        return new Line(List.of(points));
    }

    private Point leftPoint(AtomicInteger column) {
        if (column.get() <= ZERO.getValue()) {
            column.incrementAndGet();
        }
        return this.points.get(column.decrementAndGet());
    }

    private Point currentPoint(AtomicInteger column) {
        if (column.get() == this.size()) {
            column.decrementAndGet();
        }
        return this.points.get(column.getAndIncrement());
    }

    public int moveLeftAndRight(int column) {
        AtomicInteger leftColumn = new AtomicInteger(column);
        AtomicInteger currentColumn = new AtomicInteger(column);

        Point leftPoint = this.leftPoint(leftColumn);
        Point columnPoint = this.currentPoint(currentColumn);

        if (column != ZERO.getValue() && leftPoint.value()) {
            return leftColumn.get();
        }

        if (columnPoint.value()) {
            return currentColumn.get();
        }

        return column;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(this.points);
    }

    public int size() {
        return this.points.size();
    }
}
