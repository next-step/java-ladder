package ladder.step2.dto;

import ladder.step2.domain.Player;

public class PlayerDTO {
    private final String playerName;
    
    public PlayerDTO(Player player) {
        this.playerName = player.getPlayerName();
    }
    
    public String getPlayerName() {
        return playerName;
    }
}
