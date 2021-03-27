package ladder.domain;

import ladder.strategy.Point;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String MINIMUM_PERSON_ERRRO = "2명 이상 참여해야합니다.";
    private static final int MINIMUM_PERSON = 2;
    private static final int MINUS_INDEX_SIZE = 1;

    private final PointStrategy pointStrategy;
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, Point.instance());
    }

    public Line(int countOfPerson, PointStrategy pointStrategy) {
        isPersonUnderTwo(countOfPerson);
        this.pointStrategy = pointStrategy;
        this.points = createPoints(countOfPerson);
    }

    private void isPersonUnderTwo(int countOfPerson) {
        if (MINIMUM_PERSON > countOfPerson) {
            throw new IllegalArgumentException(MINIMUM_PERSON_ERRRO);
        }
    }

    private List<Boolean> createPoints(int countOfPerson) {
        return recursionPoint((countOfPerson-MINUS_INDEX_SIZE), new ArrayList<>());
    }

    private List<Boolean> recursionPoint(int maxSize, List<Boolean> points) {
        if (points.isEmpty()) {
            recursionPoint(maxSize, addPoint(points, pointStrategy.isPoint()));
        }
        if (maxSize == points.size()) {
            return addPoint(points, Boolean.FALSE);
        }
        if (!isMaxSize(maxSize, points) && !points.get(points.size()-MINUS_INDEX_SIZE)) {
            recursionPoint(maxSize, addPoint(points, pointStrategy.isPoint()));
        }
        if (!isMaxSize(maxSize, points) && points.get(points.size()-MINUS_INDEX_SIZE)) {
            recursionPoint(maxSize, addPoint(points, Boolean.FALSE));
        }
        return points;
    }

    private boolean isMaxSize(int maxSize, List<Boolean> points) {
        return maxSize <= points.size();
    }

    private List<Boolean> addPoint(List<Boolean> points, boolean isPoint) {
        points.add(isPoint);
        return points;
    }

    public List<Boolean> readOnlyPoints() {
        return Collections.unmodifiableList(points);
    }
}
