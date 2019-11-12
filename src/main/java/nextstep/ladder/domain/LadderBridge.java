package nextstep.ladder.domain;

import java.util.List;

public enum LadderBridge {
    BRIDGE("-----|"),
    EMPTY("     |");

    private String bridge;

    LadderBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getBridge() {
        return bridge;
    }
}
