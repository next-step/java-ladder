package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.exception.PointAlreadyConnectedException;

public class Point {

    private Point connectedPoint;

    Point() {
        connectedPoint = this;
    }

    void connectTo(Point point) {
        if (connectedPoint != this) {
            throw new PointAlreadyConnectedException();
        }

        connectedPoint = point;
    }

    public boolean isConnectedAnotherPoint() {
        return connectedPoint != this;
    }

    public boolean isConnectedTo(Point point) {
        return connectedPoint == point;
    }

    public Point getConnectedPoint() {
        return connectedPoint;
    }

}
