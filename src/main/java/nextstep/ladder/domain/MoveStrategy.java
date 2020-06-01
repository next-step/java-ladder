package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.NotExistMoveStrategyException;

import java.util.Arrays;

public enum MoveStrategy {
    MOVE_LEFT(true, false),
    MOVE_RIGHT(false, true),
    STAY(false, false);

    private boolean currentPointStatus;
    private boolean nextPointStatus;

    MoveStrategy(boolean currentPointStatus, boolean nextPointStatus) {
        this.currentPointStatus = currentPointStatus;
        this.nextPointStatus = nextPointStatus;
    }

    public static MoveStrategy create(boolean currentPointStatus, boolean nextPointStatus) {
        return Arrays.stream(MoveStrategy.values())
                .filter(moveStrategy -> moveStrategy.getCurrentPointStatus() == currentPointStatus &&
                        moveStrategy.getNextPointStatus() == nextPointStatus)
                .findFirst()
                .orElseThrow(() -> new NotExistMoveStrategyException("Such MoveStrategy not exists"));
    }

    private boolean getCurrentPointStatus() {
        return currentPointStatus;
    }

    private boolean getNextPointStatus() {
        return nextPointStatus;
    }
}
