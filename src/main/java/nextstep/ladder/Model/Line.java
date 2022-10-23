package nextstep.ladder.Model;

import nextstep.ladder.Strategy.ConnectBridgeStrategy;

import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> line;

    public Line(List<Point> line) {
        this.line = line;
    }

    public void checkDecidingConnectBridge(ConnectBridgeStrategy connectBridgeStrategy, int peopleCount) {
        int currentLastLocation = line.size() - 1;
        int size = line.size();
        if (line.isEmpty()) {
            line.add(new Point(0, Bridge.first(connectBridgeStrategy)));
            return;
        }
        Point beforePoint = line.get(currentLastLocation);
        Bridge beforeBridge = beforePoint.getBridgeInfo();
        if (size + 1 == peopleCount) {
            line.add(new Point(currentLastLocation + 1, beforeBridge.last()));
            return;
        }
        line.add(new Point(currentLastLocation + 1, beforeBridge.next(connectBridgeStrategy)));
    }

    public int move(int currentLocation) {
        Point point = line.get(currentLocation);
        return point.move();
    }

    public List<Point> getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line1 = (Line) o;
        return Objects.equals(getLine(), line1.getLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLine());
    }
}
