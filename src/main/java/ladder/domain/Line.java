package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line of(final int countOfPerson, PointStrategy pointStrategy) {
        List<Boolean> points = new ArrayList<>();
        Boolean beforePoint = Boolean.FALSE;
        for (int i = 0; i < countOfPerson; i++) {
            Boolean point = generatePoint(beforePoint, pointStrategy, isLastIndex(i, countOfPerson));
            points.add(point);
            beforePoint = point;
        }
        return new Line(points);
    }

    private static Boolean generatePoint(final Boolean beforePoint, PointStrategy pointStrategy,
                                         final boolean isLastIndex) {
        if (beforePoint || isLastIndex) {
            return Boolean.FALSE;
        }
        return pointStrategy.generator();
    }

    private static boolean isLastIndex(int index, int countOfPerson) {
        return index + 1 == countOfPerson;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
