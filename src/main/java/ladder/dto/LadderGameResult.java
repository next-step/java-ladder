package ladder.dto;

import ladder.domain.Player;
import ladder.domain.Prize;

public class LadderGameResult {

    private String playerName;

    private String prizeName;

    public LadderGameResult(Player player, Prize prize) {
        playerName = player.name();
        prizeName = prize.toString();
    }

    public String playerName() {
        return playerName;
    }

    public String prizeName() {
        return prizeName;
    }
}
