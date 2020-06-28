package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String INVALID_LINE_LENGTH = "Line 길이는 2이상으로 생성 할 수 있습니다.";
    private static final String INVALID_LINE_POSITION = "Line 범위를 넘어선 위치는 확인할 수 없습니다.";
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
        return new ArrayList<>(points);
    }

    private List<Boolean> makePoints(int length, GenerableStrategy generableStrategy) {
        initializePoints(length);

        for (int current = 0; current < length; current++) {
            Boolean hasPoint = generableStrategy.generate();
            if (hasPoint && canBePoint(current)) {
                points.set(current, true);
            }
        }
        return points;
    }

    private List<Boolean> initializePoints(int length) {
        points = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            points.add(false);
        }
        return points;
    }

    private boolean canBePoint(int currentPosition) {
        if (hasPreviousPositionPoint(currentPosition)) {
            return false;
        }
        if (hasNextPositionPoint(currentPosition)) {
            return false;
        }
        return true;
    }

    private boolean isInLine(int position) {
        if (position >= 0 && position <= points.size() - 1) {
            return true;
        }
        return false;
    }

    private boolean hasPreviousPositionPoint(int currentPosition) {
        int previousPosition = currentPosition - 1;
        if (isInLine(previousPosition) && points.get(previousPosition)) {
            return true;
        }
        return false;
    }

    private boolean hasNextPositionPoint(int currentPosition) {
        int nextPosition = currentPosition + 1;
        if (isInLine(nextPosition) && points.get(nextPosition)) {
            return true;
        }
        return false;
    }

    private boolean isValidPositionInLine(int position) {
        if (position < 0 || position > points.size()) {
            return false;
        }
        return true;
    }

    public void move(User user) {
        if (!isValidPositionInLine(user.getCurrentPosition())) {
            throw new IllegalArgumentException(INVALID_LINE_POSITION);
        }
        if (hasPreviousPositionPoint(user.getCurrentPosition())) {
            user.moveLeft();
            return;
        }

        if (hasNextPositionPoint(user.getCurrentPosition() - 1)) {
            user.moveRight();
            return;
        }
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
