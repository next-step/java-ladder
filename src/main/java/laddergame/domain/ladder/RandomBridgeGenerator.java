package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private static final int MIN_PLAYER = 1;
    private static final Random RANDOM = new Random();

    @Override
    public List<Bridge> generate(int numberOfPlayer) {
        if (isOnePlayer(numberOfPlayer)) {
            return Arrays.asList(Bridge.createNotLinkedBridge());
        }

        Bridge firstBridge = generateFirstBridge();

        List<Bridge> bridges = new ArrayList<>(generateMiddleBridges(firstBridge, numberOfPlayer));

        bridges.add(generateLastBridge(bridges, numberOfPlayer));

        return bridges;
    }

    private Bridge generateFirstBridge() {
        if (RANDOM.nextBoolean()) {
            return Bridge.createRightBridge();
        }

        return Bridge.createNotLinkedBridge();
    }

    private List<Bridge> generateMiddleBridges(Bridge firstBridge, int numberOfPlayer) {
        List<Bridge> bridges = new ArrayList<>();

        bridges.add(firstBridge);

        for (int beforeIndex = 0; beforeIndex < numberOfPlayer - 2; beforeIndex++) {
            Bridge beforeBridge = bridges.get(beforeIndex);
            bridges.add(generateNextBridge(RANDOM.nextBoolean(), beforeBridge));
        }

        return bridges;
    }

    private Bridge generateLastBridge(List<Bridge> bridges, int numberOfPlayer) {
        Bridge beforeBridge = bridges.get(numberOfPlayer - 2);

        if (beforeBridge.getBridgeType().isRightConnected()) {
            return Bridge.createLeftBridge();
        }

        return Bridge.createNotLinkedBridge();
    }

    private Bridge generateNextBridge(boolean isConnected, Bridge beforeBridge) {
        if (beforeBridge.getBridgeType().isRightConnected()) {
            return Bridge.createLeftBridge();
        }

        if (isConnected) {
            return Bridge.createRightBridge();
        }

        return Bridge.createNotLinkedBridge();
    }

    private boolean isOnePlayer(int numberOfPlayer) {
        if (numberOfPlayer == MIN_PLAYER) {
            return true;
        }

        return false;
    }

}
