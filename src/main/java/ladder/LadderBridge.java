package ladder;

import java.util.*;

public enum LadderBridge {
    EXIST,
    UN_EXIST;

    private static final List<LadderBridge> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int VALUES_SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static LadderBridge makeRandomBridge(final LadderBridge preBridge) {
        return Optional.ofNullable(preBridge)
                .filter(bridge -> bridge == EXIST)
                .map(bridge -> UN_EXIST)
                .orElse(randomBridge());
    }

    public static LadderBridge randomBridge() {
        return VALUES.get(RANDOM.nextInt(VALUES_SIZE));
    }
}
