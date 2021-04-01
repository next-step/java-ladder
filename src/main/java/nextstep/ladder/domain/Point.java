package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.PointAlreadyConnectedException;

public class Point {

    private Point connectedPoint;

    public Point() {
        connectedPoint = this;
    }

    public void connectTo(Point point) {
        if (connectedPoint != this) {
            throw new PointAlreadyConnectedException();
        }

        connectedPoint = point;
        if (!point.isConnectedAnotherPoint()) {
            point.connectTo(this);
        }
    }

    public boolean isConnectedAnotherPoint() {
        return connectedPoint != this;
    }

}