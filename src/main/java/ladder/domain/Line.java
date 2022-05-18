package ladder.domain;

import ladder.constant.Point;
import ladder.exception.ContinuousConnectionException;
import ladder.exception.InvalidCountOfPersonException;
import ladder.strategy.GenerationStrategy;

import java.util.List;
import java.util.Objects;

public class Line {

    public static final int MIN_COUNT_OF_PERSON = 2;
    private static final int INITIAL_INDEX = 0;
    private static final int EXCLUSION_VALUE = 1;
    private static final int PREVIOUS_VALUE = 1;

    private final List<Point> points;

    public Line(int countOfPerson, GenerationStrategy strategy) {
        this(strategy.generatePoints(totalPoint(countOfPerson)));
    }

    public Line(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            validateContinuousConnect(points, i);
        }
    }

    private void validateContinuousConnect(List<Point> points, int currentIndex) {
        if (!continuousConnected(points, currentIndex)) {
            return;
        }
        throw new ContinuousConnectionException();
    }

    private boolean continuousConnected(List<Point> points, int currentIndex) {
        if (currentIndex == INITIAL_INDEX) {
            return false;
        }
        return points.get(currentIndex).isConnect()
                && points.get(currentIndex - PREVIOUS_VALUE).isConnect();
    }

    private static int totalPoint(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new InvalidCountOfPersonException();
        }
        return countOfPerson - EXCLUSION_VALUE;
    }

    public int countPoint() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return this.points.toString();
    }
}

