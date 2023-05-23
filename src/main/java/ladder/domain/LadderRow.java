package ladder.domain;

import java.util.Arrays;

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
        if (isRightConnected(currentPoint)) {
            return currentPoint + 1;
        }

        if (isLeftConnected(currentPoint)) {
            return currentPoint - 1;
        }

        return currentPoint;
    }

    public boolean isRightConnected(int point) {
        return (point < connectedPoints.length && connectedPoints[point]);
    }

    public boolean isLeftConnected(int point) {
        return (point > 0 && connectedPoints[point - 1]);
    }

    public String print() {
        if (connectedPoints.length == 0) {
            return "|";
        }

        return Arrays.stream(connectedPoints)
                .map(isConnected -> isConnected ? "|-----" : "|     ")
                .reduce((left, right) -> left + right)
                .map(row -> row + "|")
                .orElse("");
    }
}
