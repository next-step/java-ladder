package nextstep.ladder.domain.point;

import nextstep.ladder.domain.point.strategy.ConnectedPointGenerateStrategy;

public class ConnectedPoints {

    private final Points points;
    private final int connectedPointLimit;

    public ConnectedPoints(int ladderHeight, ConnectedPointGenerateStrategy strategy) {
        this.connectedPointLimit = ladderHeight - 1; // 사다리 높이가 5인 경우 5개를 모두 연결한다면, 다음 사다리에서는 연결할 수 없다.
        this.points = new Points(ladderHeight);
        setUp(strategy);
    }

    private void setUp(ConnectedPointGenerateStrategy strategy) {
        while (strategy.hasNext()) {
            connect(strategy.generate());
        }
    }

    private void connect(int point) {
        if (hasCapacity()) {
            points.connect(point);
        }
    }

    private boolean hasCapacity() {
        return points.connectableCount() >= connectedPointLimit;
    }

    public boolean isConnected(int point) {
        return points.isConnected(point);
    }

    public void connectNotDuplicated(ConnectedPoints connectedPoints) {
        for (int i = 0; i < points.size(); i++) {
            if (connectable(i) && !connectedPoints.isConnected(i)) {
                connect(i);
                return;
            }
        }
    }

    public void disConnect(int point) {
        points.unUse(point);
    }

    private boolean connectable(int point) {
        return points.connectable(point);
    }

    public int connectedCount() {
        return points.count(Point.CONNECTED);
    }

    @Override
    public String toString() {
        return "ConnectedPoints{" +
                "points=" + points +
                ", connectedPointLimit=" + connectedPointLimit +
                '}';
    }
}
