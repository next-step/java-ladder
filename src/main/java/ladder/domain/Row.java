package ladder.domain;

import ladder.generator.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int MAX_BRIDGES_PER_ROW_DIVISOR = 2;
    private final List<Bridge> bridges;

    private Row(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Row generateRow(int playerCount, BridgeGenerator bridgeGenerator) {
        List<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            Bridge bridge = bridgeGenerator.generate();

            boolean connectedWithPrevious = isConnectedWithPrevious(bridge, i, bridges);
            bridges.add(connectedWithPrevious ? Bridge.DISCONNECTED : bridge);
        }

        return new Row(bridges);
    }

    private static boolean isConnectedWithPrevious(Bridge bridge, int position, List<Bridge> bridges) {
        return bridge == Bridge.CONNECTED && isPreviousConnected(position, bridges);
    }

    private static boolean isPreviousConnected(int position, List<Bridge> bridges) {
        int left = position - 1;

        if (left < 0) {
            return false;
        }

        return bridges.get(left) == Bridge.CONNECTED;
    }

    public static int calculateMaxBuildableBridges(int players) {
        return players / MAX_BRIDGES_PER_ROW_DIVISOR;
    }

    public boolean isConnected(int position) {
        return bridges.get(position) == Bridge.CONNECTED;
    }
}
