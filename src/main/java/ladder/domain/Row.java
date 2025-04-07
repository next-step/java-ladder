package ladder.domain;

import java.util.Random;
import java.util.Set;

public class Row {
    private static final int MAX_BRIDGES_PER_ROW_DIVISOR = 2;
    private final Set<Bridge> bridges;

    private Row(Set<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Row generateRow(int playerCount, RowGenerator rowGenerator) {
        return new Row(rowGenerator.generate(playerCount));
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

    public static int calculateMaxBuildableBridges(int players) {
        return players / MAX_BRIDGES_PER_ROW_DIVISOR;
    }

}
