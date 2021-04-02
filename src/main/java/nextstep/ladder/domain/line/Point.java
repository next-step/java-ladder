package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.exception.PointAlreadyConnectedException;

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

}
