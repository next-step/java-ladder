package step2.domain;

import static step2.view.ViewConstants.LADDER_BRIDGE;
import static step2.view.ViewConstants.LADDER_EMPTY;

public enum LadderType {
    EMPTY(LADDER_EMPTY),
    LEFT(LADDER_BRIDGE),
    RIGHT(LADDER_EMPTY);

    private String ladder;

    LadderType(String ladder) {
        this.ladder = ladder;
    }

    public String ladder() {
        return this.ladder;
    }
}
