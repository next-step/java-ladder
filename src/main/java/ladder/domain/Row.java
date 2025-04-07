package ladder.domain;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Row {
    private static final int MAX_BRIDGES_PER_ROW_DIVISOR = 2;
    private static final Random RANDOM = new Random();
    private final Set<Bridge> bridges;

    private Row(Set<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Row generateRow(int players) {
        final int maxAttempts = 100;
        final int bridgeCount = getRandomBridgeCount(players);

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            Set<Bridge> bridgeSet = generateBridgeCombinations(players, bridgeCount);

            if (isBuildable(bridgeSet)) {
                return new Row(bridgeSet);
            }
        }

        throw new IllegalStateException("Row 생성에 실패하였습니다.");
    }

    private static Set<Bridge> generateBridgeCombinations(int players, int bridgeCount) {
        Set<Bridge> bridgeSet = new TreeSet<>();

        while (bridgeSet.size() < bridgeCount) {
            bridgeSet.add(Bridge.generateRandomBridge(players));
        }

        return bridgeSet;
    }

    public static boolean isBuildable(Set<Bridge> bridges) {
        for (Bridge bridge : bridges) {
            Bridge leftBridge = bridge.getLeftBridge();
            Bridge rightBridge = bridge.getRightBridge();

            if (bridges.contains(leftBridge) || bridges.contains(rightBridge)) {
                return false;
            }
        }

        return true;
    }

    public boolean shouldBuildBridge(int position) {
        return bridges.contains(new Bridge(position));
    }

    private static int getRandomBridgeCount(int players) {
        return RANDOM.nextInt(calculateMaxBuildableBridges(players) + 1);
    }

    public static int calculateMaxBuildableBridges(int players) {
        return players / MAX_BRIDGES_PER_ROW_DIVISOR;
    }

}
