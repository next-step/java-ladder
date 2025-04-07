package ladder.domain;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomRowGenerator implements RowGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public Set<Bridge> generate(int playerCount) {

        final int maxAttempts = 100;
        final int bridgeCount = getRandomBridgeCount(playerCount);


        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            Set<Bridge> bridges = new TreeSet<>();

            while (bridges.size() < bridgeCount) {
                bridges.add(Bridge.generateRandomBridge(playerCount));
            }

            if (Row.isBuildable(bridges)) {
                return bridges;
            }
        }

        throw new IllegalStateException("Row 생성에 실패하였습니다.");
    }

    private int getRandomBridgeCount(int players) {
        return RANDOM.nextInt(Row.calculateMaxBuildableBridges(players) + 1);
    }

}
