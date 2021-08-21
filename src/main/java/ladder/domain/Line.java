package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import ladder.exception.PersonCountException;
import ladder.strategy.NoMovableStrategy;
import ladder.strategy.RandomlyMovableStrategy;

public class Line {
    private static final String PERSON_MIN_NUMBER_EXCEPTION_COMMENT = "사람 수는 최소 %d명 이상이어야 합니다.";
    private static final int PERSON_MIN_NUMBER = 2;
    private static final int START_INDEX_MIDDLE_LINE = 1;

    private final List<Point> points;

    private Line(int countOfPerson) {
        validate(countOfPerson);
        List<Point> points = new ArrayList<>();
        constructLine(countOfPerson, points);
        this.points = Collections.unmodifiableList(points);
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

    private void validate(final int countOfPerson) {
        if (countOfPerson < PERSON_MIN_NUMBER) {
            throw new PersonCountException(String.format(PERSON_MIN_NUMBER_EXCEPTION_COMMENT, PERSON_MIN_NUMBER));
        }
    }

    private void constructLine(final int countOfPerson, final List<Point> points) {
        points.add(Point.of(new NoMovableStrategy(), new NoMovableStrategy()));
        IntStream.range(START_INDEX_MIDDLE_LINE, countOfPerson)
            .forEach(i -> points.add(Point.fromMiddle(points.get(i - 1), new RandomlyMovableStrategy())));
    }

    public List<Point> toList() {
        return points;
    }
}
