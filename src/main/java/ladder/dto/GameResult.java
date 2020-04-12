package ladder.dto;

import ladder.domain.Player;
import ladder.domain.Prize;

public class GameResult {
    private Player player;
    private Prize prize;

    public GameResult(Player player, Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public Player getPlayer() {
        return player;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPrize() {
        return prize.getPrize();
    }
}
