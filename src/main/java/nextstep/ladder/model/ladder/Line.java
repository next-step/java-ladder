package nextstep.ladder.model.ladder;

import nextstep.ladder.exception.LadderLengthException;
import nextstep.ladder.util.RandomBoolean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.model.ConstantNumber.*;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    private static void isMinimum(int countOfPeople) {
        Optional.of(countOfPeople)
                .filter(count -> TWO.getValue() <= count)
                .orElseThrow(LadderLengthException::new);
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
        return column -> points.set(column + ONE.getValue(), Point.of(false));
    }

    private static UnaryOperator<List<Point>> removable() {
        return points -> {
            int lastColumn = points.size() - ONE.getValue();
            IntStream.range(ZERO.getValue(), lastColumn)
                    .filter(isAdjacentPointsHaveLines(points))
                    .forEach(setNextPointNoLine(points));
            points.set(lastColumn, Point.of(false));
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

    private int moveLeft(int column) {
        int currentColumn = column;
        if (column == ZERO.getValue()) {
            column++;
        }

        Point point = this.points.get(--column);

        if (currentColumn != ZERO.getValue() && point.value()) {
            return column;
        }

        return currentColumn;
    }

    private int moveRight(int column) {
        int currentColumn = column;
        if (column == this.size()) {
            column--;
        }
        Point point = this.points.get(column++);

        if (point.value()) {
            return column;
        }

        return currentColumn;
    }

    public int moveLeftAndRight(int column) {
        int leftColumn = this.moveLeft(column);
        int rightColumn = this.moveRight(column);

        if (leftColumn < column) {
            return leftColumn;
        }

        return Math.max(column, rightColumn);

    }

    public List<Point> points() {
        return Collections.unmodifiableList(this.points);
    }

    public int size() {
        return this.points.size();
    }
}
