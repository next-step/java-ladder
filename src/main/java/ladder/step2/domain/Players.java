package ladder.step2.domain;

import ladder.step2.dto.PlayerNameDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<PlayerName> players;
    
    public Players(List<PlayerName> players) {
        this.players = players;
    }
    
    public int size() {
        return players.size();
    }
    
    public List<PlayerNameDTO> playerNamesInformation() {
        return players.stream()
                .map(PlayerName::playerNameInformation)
                .collect(Collectors.toList());
    }
}
