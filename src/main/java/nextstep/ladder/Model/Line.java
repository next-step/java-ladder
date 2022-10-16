package nextstep.ladder.Model;

import nextstep.ladder.Strategy.ConnectBridgeStrategy;

import java.util.List;
import java.util.Objects;

public class Line {

    private static final int STANDARD_START_LOCATION = -1;
    private List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public void checkThisPointIsAbleConnectAndExecuteConnect(ConnectBridgeStrategy connectBridgeStrategy) {
        int cureentLastLocation = line.size() - 1;
        if (cureentLastLocation == STANDARD_START_LOCATION) {
            line.add(false);
            return;
        }
        if (checkThisPointIsAbleConnect(cureentLastLocation)) {
            line.add(false);
            return;
        }
        line.add(checkConnectBridge(connectBridgeStrategy));
    }

    private boolean checkConnectBridge(ConnectBridgeStrategy connectBridgeStrategy) {
        return connectBridgeStrategy.makeBridge();
    }

    private boolean checkThisPointIsAbleConnect(int cureentLastLine) {
        return line.get(cureentLastLine) == true;
    }

    public List<Boolean> getLine() {
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
