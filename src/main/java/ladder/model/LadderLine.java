package ladder.model;

import java.util.*;

public class LadderLine {
    private final List<LadderPoint> points;

    LadderLine(List<LadderPoint> points) {
        validateNotEmptyPoints(points);
        this.points = points;
    }

    private void validateNotEmptyPoints(List<LadderPoint> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("포인트 목록이 비었습니다.");
        }
    }

    int pointCount() {
        return points.size();
    }

    public List<LadderPoint> getPoints() {
        return points;
    }

    LadderPoint getPoint(int pointIndex) {
        return points.get(pointIndex);
    }

    int findPlayerIndexAfterCrossingLine(int playerIndex) {
        LadderPoint point = points.get(playerIndex);
        return point.move();
    }
}