package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import ladder.utils.RandomGenerator;

public enum LadderBridge {
    EXIST,
    NOT_EXIST;

    private static final List<LadderBridge> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static final int VALUES_SIZE = VALUES.size();

    public static LadderBridge makeLadderBridgeByPreBridge(final LadderBridge preBridge) {
        return Optional.ofNullable(preBridge)
            .filter(bridge -> bridge == EXIST)
            .map(bridge -> NOT_EXIST)
            .orElseGet(LadderBridge::randomBridge);
    }

    public static LadderBridge randomBridge() {
        return VALUES.get(RandomGenerator.create());
    }
}
