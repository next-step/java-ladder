package ladder.step2.dto;

import ladder.step2.domain.Player;
import ladder.step2.domain.PlayerName;
import ladder.step2.domain.Position;

public class PlayerDTO {
    private final String playerName;
    private final int position;
    
    public PlayerDTO(Player player) {
        final PlayerName playerName = player.getPlayerName();
        this.playerName = playerName.getPlayerName();
        
        final Position position = player.getPosition();
        this.position = position.getPosition();
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public int getPosition() {
        return position;
    }
}
