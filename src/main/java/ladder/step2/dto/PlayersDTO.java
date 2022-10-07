package ladder.step2.dto;

import ladder.step2.domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersDTO {
    private final List<PlayerDTO> playerDTOS;
    
    public PlayersDTO(final Players players) {
        this.playerDTOS = parsePlayerDTOS(players);
    }
    
    private List<PlayerDTO> parsePlayerDTOS(final Players players) {
        return players.getPlayers().stream()
                .map(PlayerDTO::new)
                .collect(Collectors.toList());
    }
    
    public List<PlayerDTO> getPlayerDTOS() {
        return playerDTOS;
    }
}
