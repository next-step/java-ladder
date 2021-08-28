package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.line.VerticalLines;
import nextstep.ladder.domain.point.ConnectedPoints;
import nextstep.ladder.domain.point.strategy.ConnectedPointGenerateStrategy;

public class Ladder {

    private final int height;
    private final VerticalLines verticalLines;
    private final ConnectedPoints connectedPoints;

    public Ladder(int height, ConnectedPointGenerateStrategy strategy) {
        this.height = height;
        this.verticalLines = new VerticalLines(height);
        this.connectedPoints = new ConnectedPoints(height, strategy);
    }

    public void reArrangeConnectPoints(Ladder leftNeighborhoodLadder) {
        ConnectedPoints connectedPoints = leftNeighborhoodLadder.getConnectedPoints();
        for (int i = 0; i < height; i++) {
            reArrangeConnectPoint(connectedPoints, i);
        }
    }

    private void reArrangeConnectPoint(ConnectedPoints leftConnectedPoints, int point) {
        if (hasSameConnectedPoints(leftConnectedPoints, point)) {
            this.connectedPoints.disConnect(point);
            this.connectedPoints.connectNotDuplicated(leftConnectedPoints);
        }
    }

    private boolean hasSameConnectedPoints(ConnectedPoints connectedPoints, int point) {
        return this.connectedPoints.isConnected(point) && connectedPoints.isConnected(point);
    }

    public boolean isConnected(int point) {
        return connectedPoints.isConnected(point);
    }

    private ConnectedPoints getConnectedPoints() {
        return connectedPoints;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "height=" + height +
                ", verticalLines=" + verticalLines +
                ", connectedPoints=" + connectedPoints +
                '}';
    }
}
