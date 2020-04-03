package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum LadderBridge {
    EXIST,
    UN_EXIST;

    private static final List<LadderBridge> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int VALUES_SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static LadderBridge makeRandomBridge(LadderBridge preBridge) {
        if (preBridge == EXIST) {
            return UN_EXIST;
        }

        return randomBridge();
    }

    private static LadderBridge randomBridge() {
        return VALUES.get(RANDOM.nextInt(VALUES_SIZE));
    }
}
