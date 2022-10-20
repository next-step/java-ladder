package ladder.step2.dto;

import ladder.step2.domain.PlayerName;
import ladder.step2.domain.Players;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersDTO {
    private final List<PlayerNameDTO> playerNameDTOS;
    
    public PlayersDTO(Players players) {
        playerNameDTOS = players.getPlayerNames()
                .stream()
                .map(PlayerName::getPlayerName)
                .map(PlayerNameDTO::new)
                .collect(Collectors.toList());
    }
    
    public List<PlayerNameDTO> getPlayerNameDTOS() {
        return Collections.unmodifiableList(playerNameDTOS);
    }
}
