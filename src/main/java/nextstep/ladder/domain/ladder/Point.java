package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.exception.PointAlreadyConnectedException;

public class Point {

    private Point connectedPoint;
    private final Lane lane;

    Point(Lane lane) {
        this.connectedPoint = this;
        this.lane = lane;
    }

    static Point of(int index) {
        return new Point(Lane.wrap(index));
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

    public Lane getLane() { return lane; }

}
