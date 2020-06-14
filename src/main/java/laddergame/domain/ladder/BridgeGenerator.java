package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BridgeGenerator {
    private static final int MIN_PLAYER = 1;

    public static List<Bridge> generate(int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        if (isOnePlayer(numberOfPlayer)) {
            return Arrays.asList(Bridge.createNotLinkedBridge(MIN_PLAYER));
        }

        Bridge firstBridge = Bridge.createBridge(connectGenerator.generateConnectionState(), MIN_PLAYER);

        List<Bridge> bridges = new ArrayList<>(generateLastBridges(firstBridge, numberOfPlayer, connectGenerator));

        return bridges;
    }

    private static List<Bridge> generateLastBridges(Bridge firstBridge, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(firstBridge);

        for (int beforeIndex = 0; beforeIndex < numberOfPlayer - 2; beforeIndex++) {
            Bridge beforeBridge = bridges.get(beforeIndex);
            bridges.add(beforeBridge.createNext(connectGenerator.generateConnectionState()));
        }

        Bridge lastBridge = bridges.get(numberOfPlayer - 2).createLast();
        bridges.add(lastBridge);

        return bridges;
    }

    private static boolean isOnePlayer(int numberOfPlayer) {
        if (numberOfPlayer == MIN_PLAYER) {
            return true;
        }

        return false;
    }

}
