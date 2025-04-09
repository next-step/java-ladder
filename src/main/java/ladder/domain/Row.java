package ladder.domain;

import ladder.generator.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private final List<Bridge> bridges;

    private Row(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Row generateRow(int playerCount, BridgeGenerator bridgeGenerator) {
        List<Bridge> bridges = new ArrayList<>();

        int numberOfBridges = playerCount - 1;
        for (int position = 0; position < numberOfBridges; position++) {
            bridges.add(generateValidBridge(position, bridges, bridgeGenerator));
        }

        return new Row(bridges);
    }

    public int move(int position) {
        if (isConnectedToLeft(position, bridges)) {
            return position - 1;
        }

        if (isConnectedToRight(position)) {
            return position + 1;
        }

        return position;
    }

    private static Bridge generateValidBridge(int position, List<Bridge> bridges, BridgeGenerator bridgeGenerator) {
        Bridge bridge = bridgeGenerator.generate();
        if (bridge == Bridge.CONNECTED && isConnectedToLeft(position, bridges)) {
            return Bridge.DISCONNECTED;
        }

        return bridge;
    }

    private static boolean isConnectedToLeft(int position, List<Bridge> bridges) {
        if (position <= 0) {
            return false;
        }

        return bridges.get(position - 1) == Bridge.CONNECTED;
    }

    public boolean isConnectedToRight(int position) {
        if (position >= bridges.size()) {
            return false;
        }

        return bridges.get(position) == Bridge.CONNECTED;
    }

}
