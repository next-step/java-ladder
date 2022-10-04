package ladder.step2.domain;

import ladder.step2.domain.dto.PlayerNameDTO;

import java.util.List;
import java.util.Objects;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
