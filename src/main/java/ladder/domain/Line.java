package ladder.domain;

import ladder.exception.PersonCountException;
import ladder.strategy.NoMovableStrategy;
import ladder.strategy.RandomlyMovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final String PERSON_MIN_NUMBER_EXCEPTION_COMMENT = "사람 수는 최소 %d명 이상이어야 합니다.";
    private static final int PERSON_MIN_NUMBER = 2;
    private static final int START_INDEX_MIDDLE_LINE = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    private Line(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        constructHead(points);
        constructMiddle(points, countOfPerson);
        constructTail(points, countOfPerson);
        this.points = Collections.unmodifiableList(points);
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public static Line from(int countOfPerson) {
        validate(countOfPerson);
        return new Line(countOfPerson);
    }

    private static void validate(final int countOfPerson) {
        if (countOfPerson < PERSON_MIN_NUMBER) {
            throw new PersonCountException(String.format(PERSON_MIN_NUMBER_EXCEPTION_COMMENT, PERSON_MIN_NUMBER));
        }
    }

    private void constructHead(List<Point> points) {
        points.add(Point.of(new NoMovableStrategy(), new RandomlyMovableStrategy()));
    }

    private void constructMiddle(List<Point> points, final int countOfPerson) {
        IntStream.range(START_INDEX_MIDDLE_LINE, countOfPerson - 1)
            .forEach(i -> points.add(Point.fromMiddle(points.get(i - 1), new RandomlyMovableStrategy())));
    }

    private void constructTail(List<Point> points, final int countOfPerson) {
        points.add(Point.of(points.get(countOfPerson - 2).existRight(), false));
    }

    public boolean existLeftOf(Index index) {
        return points.get(index.val()).existLeft();
    }

    public boolean existRightOf(Index index) {
        return points.get(index.val()).existRight();
    }

    public List<Point> toList() {
        return points;
    }

}
