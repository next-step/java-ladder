package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.NotExistMoveStrategyException;

import java.util.Arrays;

public enum HorizontalMoveStrategy {
    MOVE_LEFT(true, false, Player::moveLeft),
    MOVE_RIGHT(false, true, Player::moveRight),
    STAY(false, false, player -> {});

    private boolean currentPointStatus;
    private boolean nextPointStatus;
    private HorizontalMove horizontalMove;

    HorizontalMoveStrategy(boolean currentPointStatus, boolean nextPointStatus, HorizontalMove horizontalMove) {
        this.currentPointStatus = currentPointStatus;
        this.nextPointStatus = nextPointStatus;
        this.horizontalMove = horizontalMove;
    }

    public static HorizontalMoveStrategy create(boolean currentPointStatus, boolean nextPointStatus) {
        return Arrays.stream(HorizontalMoveStrategy.values())
                .filter(horizontalMoveStrategy -> horizontalMoveStrategy.getCurrentPointStatus() == currentPointStatus &&
                        horizontalMoveStrategy.getNextPointStatus() == nextPointStatus)
                .findFirst()
                .orElseThrow(() -> new NotExistMoveStrategyException("Such MoveStrategy not exists"));
    }

    public void move(Player player) {
        this.horizontalMove.move(player);
    }

    private boolean getCurrentPointStatus() {
        return currentPointStatus;
    }

    private boolean getNextPointStatus() {
        return nextPointStatus;
    }
}
