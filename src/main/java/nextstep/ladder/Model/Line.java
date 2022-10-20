package nextstep.ladder.Model;

import nextstep.ladder.Strategy.ConnectBridgeStrategy;

import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Bridge> line;

    public Line(List<Bridge> line) {
        this.line = line;
    }

    public void checkDecidingConnectBridge(ConnectBridgeStrategy connectBridgeStrategy) {
        int currentLastLocation = line.size() - 1;
        if (line.isEmpty()) {
            line.add(new Bridge(false));
            return;
        }
        Bridge BeforeBridge = line.get(currentLastLocation);
        if (BeforeBridge.isConnect()) {
            line.add(new Bridge(false));
            return;
        }
        line.add(checkConnectBridge(connectBridgeStrategy));
    }

    public int move(int currentLocation) {
        if (isConnectLeft(currentLocation)) {
            return currentLocation - 1;
        }
        if (isConnectRight(currentLocation)) {
            return currentLocation + 1;
        }
        return currentLocation;
    }

    private boolean isConnectRight(int currentLocation) {
        int size = line.size();
        if (currentLocation == size - 1) {
            return false;
        }
        Bridge bridge = line.get(currentLocation + 1);
        return bridge.isConnect();
    }

    private boolean isConnectLeft(int currentLocation) {
        if (currentLocation == 0) {
            return false;
        }
        Bridge bridge = line.get(currentLocation);
        return bridge.isConnect();
    }

    private Bridge checkConnectBridge(ConnectBridgeStrategy connectBridgeStrategy) {
        return new Bridge(connectBridgeStrategy.makeBridge());
    }


    public List<Bridge> getLine() {
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
