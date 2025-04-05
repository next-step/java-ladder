package ladder.domain;

import java.util.Random;

public class Bridge implements Comparable<Bridge> {
    private static final Random RANDOM = new Random();
    private final int startPosition;

    public Bridge(int startPosition) {
        this.startPosition = startPosition;
    }

    public static Bridge generateRandomBridge(int players) {
        return new Bridge(getRandomBridgePosition(players));
    }

    private static int getRandomBridgePosition(int players) {
        return RANDOM.nextInt(players - 1);
    }

    public boolean isContinuous(Bridge nextBridge) {
        return startPosition + 1 == nextBridge.startPosition;
    }

    @Override
    public int compareTo(Bridge o) {
        return startPosition - o.startPosition;
    }

}
