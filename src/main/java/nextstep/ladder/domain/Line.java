package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nextstep.ladder.exception.LineException;

public class Line {
    private static final int MIN_POINT_POSITION = 0;
    private static final int ONE_POINT = 1;

    private final int maxPointPosition;
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        maxPointPosition = countOfPerson - 2;
        points = Arrays.asList(new Boolean[countOfPerson - ONE_POINT]);
        Collections.fill(points, false);
    }

    public void makeBridge(final int point, final Draw draw) {
        if (draw.draw()) {
            ableToMake(point);
            points.set(point, true);
        }
    }

    private void ableToMake(final int point) {
        if (!isValidPosition(point)) {
            throw new LineException("올바르지 않은 위치입니다.");
        }

        final int leftPoint = point - ONE_POINT;
        if (isValidPosition(leftPoint) && hasBridge(leftPoint)) {
            throw new LineException(leftPoint + "에 이미 다리가 있습니다. 연속해서 만들 수 없습니다.");
        }

        final int rightPoint = point + ONE_POINT;
        if (isValidPosition(rightPoint) && hasBridge(rightPoint)) {
            throw new LineException(rightPoint + "에 이미 다리가 있습니다. 연속해서 만들 수 없습니다.");
        }
    }

    private boolean isValidPosition(final int point) {
        return point >= MIN_POINT_POSITION && point <= maxPointPosition;
    }

    public Boolean hasBridge(final int point) {
        return points.get(point);
    }

    public int getMaxPointPosition() {
        return maxPointPosition;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
