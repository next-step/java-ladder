package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGenerator {
    private static final int MIN_PLAYER = 1;

    public static List<Bridge> generate(int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        if (isOnePlayer(numberOfPlayer)) {
            return Arrays.asList(new Bridge(false, MIN_PLAYER));
        }

        List<Bridge> bridges = new ArrayList<>();
        bridges.add(new Bridge(connectGenerator.generateConnectionState(), MIN_PLAYER));

        return generateLastBridges(bridges, numberOfPlayer, connectGenerator);
    }

    private static List<Bridge> generateLastBridges(List<Bridge> bridges, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        for (int beforeIndex = 0; beforeIndex < numberOfPlayer - 2; beforeIndex++) {
            Bridge beforeBridge = bridges.get(beforeIndex);
            bridges.add(beforeBridge.createNextBridge(connectGenerator.generateConnectionState()));
        }

        return bridges;
    }

    private static boolean isOnePlayer(int numberOfPlayer) {
        if (numberOfPlayer == MIN_PLAYER) {
            return true;
        }

        return false;
    }

}
