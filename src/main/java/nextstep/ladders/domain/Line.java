package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.CountOfPersonZeroException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final PointGenerateStrategy strategy;
    private final List<Boolean> points;

    public Line(final int countOfPerson, final PointGenerateStrategy strategy) {
        if (countOfPerson == 0) {
            throw new CountOfPersonZeroException();
        }
        this.strategy = strategy;
        this.points = dot(countOfPerson);
    }

    private List<Boolean> dot(final int countOfPerson) {
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
}