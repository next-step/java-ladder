package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatuses {

    private final List<PlayerStatus> playerStatuses = new ArrayList<>();

    public PlayerStatuses(PlayerNames playerNames, LadderPoints ladderPoints) {
        List<PlayerName> playerNameList = playerNames.getPlayerNames();

        for (int i = 0; i < playerNameList.size(); i++) {
            PlayerName playerName = playerNameList.get(i);
            this.playerStatuses.add(new PlayerStatus(playerName, ladderPoints, i));
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
