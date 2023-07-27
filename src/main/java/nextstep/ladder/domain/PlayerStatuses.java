package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatuses {

    private final List<PlayerStatus> playerStatuses = new ArrayList<>();

    public PlayerStatuses(LadderPoints ladderPoints) {
        int playerCount = ladderPoints.getColumnCount() + 1;

        for (int i = 0; i < playerCount; i++) {
            this.playerStatuses.add(new PlayerStatus(ladderPoints, i));
        }
    }

    public List<PlayerStatus> go() {
        for (PlayerStatus playerStatus : this.playerStatuses) {
            goWhileMovable(playerStatus);
        }

        return this.playerStatuses;
    }

    private void goWhileMovable(PlayerStatus playerStatus) {
        while (playerStatus.isMovable()) {
            playerStatus.go();
        }
    }
}
