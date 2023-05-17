package ladder.domain;

import java.util.Arrays;
import java.util.Random;

public class LadderRow {
    private Boolean[] connectedPoints;

    public LadderRow(Boolean[] connectedPoints) {
        this.connectedPoints = connectedPoints;
        removeContinuousPoint(connectedPoints);
    }

    public LadderRow(int size, ConnectStrategy connectStrategy) {
        connectedPoints = new Boolean[size];
        connectedPoints = Arrays.stream(connectedPoints)
                .map(point -> connectStrategy.nextBoolean())
                .toArray(Boolean[]::new);

        removeContinuousPoint(connectedPoints);
    }

    private static void removeContinuousPoint(Boolean[] connectedPoints) {
        for (int i = 0; i < connectedPoints.length; i++) {
            if (i > 0 && connectedPoints[i - 1]) {
                connectedPoints[i] = false;
            }
        }
    }

    public int size() {
        return connectedPoints.length;
    }

    public int move(int currentPoint) {
        int pointAppliedRightMove = currentPoint;
        if (isRightConnected(pointAppliedRightMove)) {
            pointAppliedRightMove += 1;
        }

        int pointAppliedLeftMove = currentPoint;
        if (isLeftConnected(pointAppliedLeftMove)) {
            pointAppliedLeftMove -= 1;
        }

        if (pointAppliedRightMove != currentPoint
                && pointAppliedLeftMove != currentPoint) {
            throw new IllegalStateException("사다리가 정상적으로 생성되지 않았습니다.");
        }

        return currentPoint + (pointAppliedRightMove - currentPoint) + (pointAppliedLeftMove - currentPoint);
    }

    private boolean isRightConnected(int point) {
        return (point < connectedPoints.length && connectedPoints[point]);
    }

    private boolean isLeftConnected(int point) {
        return (point > 0 && connectedPoints[point - 1]);
    }

    public String print() {
        if (connectedPoints.length == 0) {
            return "|";
        }

        return Arrays.stream(connectedPoints)
                .map(point -> (point == true) ? "|-----" : "|     ")
                .reduce((left, right) -> left + right)
                .map(row -> row + "|")
                .orElse("");
    }
}
