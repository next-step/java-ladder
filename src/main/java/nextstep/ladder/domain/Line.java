package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String INVALID_LINE_LENGTH = "Line 길이는 2이상으로 생성 할 수 있습니다.";
    private List<Boolean> points;

    public Line(int length, GenerableStrategy generableStrategy) {
        validateLength(length);
        points = makePoints(length, generableStrategy);
    }

    private void validateLength(int length) {
        if (length < 1) {
            throw new IllegalArgumentException(INVALID_LINE_LENGTH);
        }
    }

    public int getLadderLength() {
        return points.size();
    }

    public List<Boolean> getLine() {
        List<Boolean> deepCopiedPoints = new ArrayList<>();
        deepCopiedPoints.addAll(points);
        return deepCopiedPoints;
    }

    private List<Boolean> makePoints(int length, GenerableStrategy generableStrategy) {
        List<Boolean> points = initializePoints(length);

        for (int current = 0; current < length; current++) {
            Boolean hasPoint = generableStrategy.generate();
            if (hasPoint && canBePoint(points, current)) {
                points.set(current, true);
            }
        }
        return points;
    }

    private List<Boolean> initializePoints(int length) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            points.add(false);
        }
        return points;
    }

    private boolean canBePoint(List<Boolean> points, int currentPosition) {
        if (hasPreviousPositionPoint(points, currentPosition)) {
            return false;
        }
        if (hasNextPositionPoint(points, currentPosition)) {
            return false;
        }
        return true;
    }

    private boolean hasPreviousPositionPoint(List<Boolean> points, int currentPosition) {
        int previousPosition = currentPosition - 1;
        if (previousPosition >= 0 && points.get(previousPosition)) {
            return true;
        }
        return false;
    }

    private boolean hasNextPositionPoint(List<Boolean> points, int currentPosition) {
        int nextPosition = currentPosition + 1;
        if (nextPosition < points.size() - 1 && points.get(nextPosition)) {
            return true;
        }
        return false;
    }

    public List<Boolean> getLine() {
        List<Boolean> deepCopiedLadders = new ArrayList<>();
        deepCopiedLadders.addAll(ladders);
        return deepCopiedLadders;
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
