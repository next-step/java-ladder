package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Row {
    private static final Random RANDOM = new Random();
    private final List<Bridge> bridges;

    private Row(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Row generateRow(int players) {
        final int maxAttempts = 100;
        final int bridgeCount = getRandomBridgeCount(players);

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            List<Bridge> bridges = new ArrayList<>(generateBridgeCombinations(players, bridgeCount));

            if (isInstallable(bridges)) {
                return new Row(bridges);
            }
        }

        throw new IllegalStateException("Row 생성에 실패하였습니다.");
    }

    private static Set<Bridge> generateBridgeCombinations(int players, int bridgeCount) {
        Set<Bridge> bridgeSet = new TreeSet<>();

        while (bridgeSet.size() < bridgeCount) {
            bridgeSet.add(new Bridge(getRandomBridgePosition(players)));
        }

        return bridgeSet;
    }

    public static boolean isInstallable(List<Bridge> bridges) {
        return IntStream.range(0, bridges.size() - 1)
                .noneMatch(i -> bridges.get(i).isContinuous(bridges.get(i + 1)));
    }

    private static int getRandomBridgeCount(int players) {
        return RANDOM.nextInt(calculateMaxInstallableBridges(players) + 1);
    }

    private static int getRandomBridgePosition(int players) {
        return RANDOM.nextInt(players - 1);
    }

    public static int calculateMaxInstallableBridges(int players) {
        return players / 2;
    }

}
