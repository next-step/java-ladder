package ladder.domain;

import ladder.constant.Point;
import ladder.exception.InvalidCountOfPersonException;
import ladder.strategy.GenerationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    public static final int MIN_COUNT_OF_PERSON = 2;
    private static final int INITIAL_INDEX = 0;
    private static final int EXCLUSION_VALUE = 1;
    private static final int PREVIOUS_VALUE = 1;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, GenerationStrategy strategy) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new InvalidCountOfPersonException();
        }

        for (int i = INITIAL_INDEX; i < totalPoint(countOfPerson); i++) {
            if (isPreviousPointConnected(i)) {
                this.points.add(Point.DISCONNECTED);
                continue;
            }
            this.points.add(strategy.generatePoint());
        }
    }

    private static int totalPoint(int countOfPerson) {
        return countOfPerson - EXCLUSION_VALUE;
    }

    private boolean isPreviousPointConnected(int currentIndex) {
        if (currentIndex == INITIAL_INDEX) {
            return false;
        }
        return points.get(currentIndex - PREVIOUS_VALUE).isConnect();
    }

    public int countPoint() {
        return points.size();
    }

    public List<Point> points() {
        return points;
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

