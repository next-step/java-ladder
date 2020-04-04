package nextstep.ladder.domain;

import java.util.List;

public class Bridge {
    private final int linePosition;
    private final int stepPosition;

    private Bridge(int linePosition, int stepPosition) {
        this.linePosition = linePosition;
        this.stepPosition = stepPosition;
    }

    public static Bridge previousBridge(int linePosition, int stepPosition) {
        return new Bridge(linePosition - 1, stepPosition);
    }

    public static Bridge currentBridge(int linePosition, int stepPosition) {
        return new Bridge(linePosition, stepPosition);
    }

    public static Bridge nextBridge(int linePosition, int stepPosition) {
        return new Bridge(linePosition + 1, stepPosition);
    }

    public static Bridge nextBridge(Bridge bridge) {
        return new Bridge(bridge.linePosition + 1, bridge.stepPosition);
    }

    public static Bridge previousBridge(Bridge bridge) {
        return new Bridge(bridge.linePosition - 1, bridge.stepPosition);
    }

    public int getLinePosition() {
        return linePosition;
    }

    public int getStepPosition() {
        return stepPosition;
    }
}
