package nextstep.ladder.domain;

import java.util.Arrays;

public enum LadderBridge {
    FIRST_BRIDGE("    |-----", true),
    FIRST_EMPTY("    |     ", false),
    BRIDGE("|-----", true),
    EMPTY("|     ", false);

    private String bridge;
    private boolean isBridge;

    LadderBridge(String bridge, boolean isBridge) {
        this.bridge = bridge;
        this.isBridge = isBridge;
    }

    public String getBridge() {
        return bridge;
    }

    public static LadderBridge findLadderBridge(boolean isBridge, boolean isFirst) {
        return Arrays.stream(values())
                .filter(ladderBridge -> ladderBridge.isBridge == isBridge)
                .filter(ladderBridge -> {
                    return isFirst ? isFirstBridge(ladderBridge) : !isFirstBridge(ladderBridge);
                })
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean isFirstBridge(LadderBridge ladderBridge) {
        return ladderBridge.name().contains("FIRST");
    }
}
