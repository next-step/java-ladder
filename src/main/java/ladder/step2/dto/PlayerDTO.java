package ladder.step2.dto;

import ladder.step2.domain.Player;
import ladder.step2.domain.PlayerName;

public class PlayerDTO {
    private final String playerName;
    
    public PlayerDTO(Player player) {
        final PlayerName playerName = player.getPlayerName();
        this.playerName = playerName.getPlayerName();
    }
    
    public String getPlayerName() {
        return playerName;
    }
}
