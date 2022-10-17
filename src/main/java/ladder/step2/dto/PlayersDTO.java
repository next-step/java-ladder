package ladder.step2.dto;

import ladder.step2.domain.PlayerName;
import ladder.step2.domain.Players;

import java.util.Collections;
import java.util.List;

public class PlayersDTO {
    private final List<PlayerName> playerNames;
    
    public PlayersDTO(Players players) {
        playerNames = players.getPlayerNames();
    }
    
    public int size() {
        return playerNames.size();
    }
    
    public List<PlayerName> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}
