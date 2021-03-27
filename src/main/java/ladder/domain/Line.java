package ladder.domain;

import ladder.strategy.Point;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String MINIMUM_PERSON_ERROR = "2명 이상 참여해야합니다.";
    private static final int MINIMUM_PERSON = 2;
    private static final int MINUS_INDEX_SIZE = 1;

    private final PointStrategy pointStrategy;
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, Point.instance());
    }

    public Line(int countOfPerson, PointStrategy pointStrategy) {
        isCountOfPersonUnderTwo(countOfPerson);
        this.pointStrategy = pointStrategy;
        this.points = createPoints(countOfPerson);
    }

    private void isCountOfPersonUnderTwo(int countOfPerson) {
        if (MINIMUM_PERSON > countOfPerson) {
            throw new IllegalArgumentException(MINIMUM_PERSON_ERROR);
        }
    }

    private List<Boolean> createPoints(int countOfPerson) {
        return recursionPoint((countOfPerson-MINUS_INDEX_SIZE), new ArrayList<>());
    }

    private List<Boolean> recursionPoint(int downGradeMaxSize, List<Boolean> points) {
        if (points.isEmpty()) {
            recursionPoint(downGradeMaxSize, addPoint(points, pointStrategy.isPoint()));
        }
        if (downGradeMaxSize == points.size()) {
            return addPoint(points, Boolean.FALSE);
        }
        if (!isMaxSize(downGradeMaxSize, points) && !points.get(points.size()-MINUS_INDEX_SIZE)) {
            recursionPoint(downGradeMaxSize, addPoint(points, pointStrategy.isPoint()));
        }
        if (!isMaxSize(downGradeMaxSize, points) && points.get(points.size()-MINUS_INDEX_SIZE)) {
            recursionPoint(downGradeMaxSize, addPoint(points, Boolean.FALSE));
        }
        return points;
    }

    private boolean isMaxSize(int downGradeMaxSize, List<Boolean> points) {
        return downGradeMaxSize <= points.size();
    }

    private List<Boolean> addPoint(List<Boolean> points, boolean isPoint) {
        points.add(isPoint);
        return points;
    }

    public List<Boolean> readOnlyPoints() {
        return Collections.unmodifiableList(points);
    }
}
