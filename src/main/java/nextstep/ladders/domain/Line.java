package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.CountOfPersonZeroException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(final int countOfPerson, final PointGenerateStrategy strategy) {
        checkCountOfPersonZero(countOfPerson);
        this.points = dot(strategy, countOfPerson);
    }

    private void checkCountOfPersonZero(final int countOfPerson) {
        if (countOfPerson == 0) {
            throw new CountOfPersonZeroException();
        }
    }

    private List<Boolean> dot(final PointGenerateStrategy strategy, final int countOfPerson) {
        List<Boolean> points = new ArrayList<>(Collections.singletonList(false));
        for (int i = 1; i < countOfPerson; i++) {
            boolean previous = points.get(i - 1);
            boolean next = strategy.next(previous);
            points.add(next);
        }
        return points;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int start(final int row) {
        checkValidRowLength(row);
        return next(row);
    }

    private void checkValidRowLength(final int row) {
        if (points.size() <= row) {
            throw new IllegalArgumentException();
        }
    }

    private int next(final int row) {
        boolean left = points.get(row);
        boolean right = isNotOnTheRight(row) && points.get(row + 1);
        if (left && right) {
            throw new IllegalArgumentException();
        }
        if (left) {
            return row - 1;
        }
        if (right) {
            return row + 1;
        }
        return row;
    }

    private boolean isNotOnTheRight(final int row) {
        return row != points.size() - 1;
    }
}