package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private static final int MIN_PLAYER = 1;
    private static final Random RANDOM = new Random();

    @Override
    public List<Bridge> generate(int numberOfPlayer) {
        if (isOnePlayer(numberOfPlayer)) {
            return Collections.EMPTY_LIST;
        }
        List<Bridge> bridges = new ArrayList<>();

        bridges.add(Bridge.createFirstBrige(RANDOM.nextBoolean()));

        for (int beforeIndex = 0; beforeIndex < numberOfPlayer - 2; beforeIndex++) {
            Bridge beforeBridge = bridges.get(beforeIndex);
            bridges.add(Bridge.createNextBridge(RANDOM.nextBoolean(), beforeBridge));
        }

        return bridges;
    }

    private boolean isOnePlayer(int numberOfPlayer) {
        if (numberOfPlayer == MIN_PLAYER) {
            return true;
        }

        return false;
    }

}
