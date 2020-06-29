package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String INVALID_LINE_LENGTH = "Line 길이는 2이상으로 생성 할 수 있습니다.";
    private static final String INVALID_LINE_POSITION = "Line 범위를 넘어선 위치는 확인할 수 없습니다.";
    private List<Point> points;

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
        return points.stream()
            .map(Point::hasPoint)
            .collect(Collectors.toList());
    }

    private List<Point> makePoints(int length, GenerableStrategy generableStrategy) {
        points = new ArrayList<>();
        for (int currentPosition = 0; currentPosition < length; currentPosition++) {
            points.add(Point.makePointInLine(currentPosition, this, generableStrategy));
        }
        return points;
    }

    private boolean isInLine(int position) {
        if (position >= 0 && position < points.size()) {
            return true;
        }
        return false;
    }

    public boolean hasPreviousPositionPoint(int currentPosition) {
        int previousPosition = currentPosition - 1;
        return hasPoint(previousPosition);
    }

    public boolean hasNextPositionPoint(int currentPosition) {
        int nextPosition = currentPosition + 1;
        return hasPoint(nextPosition);
    }

    private boolean hasPoint(int position) {
        if (!isInLine(position)) {
            return false;
        }
        Point point = points.get(position);
        return point.hasPoint();
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
