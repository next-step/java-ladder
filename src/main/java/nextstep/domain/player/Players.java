package nextstep.domain.player;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int getPlayersCount(){
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList());
    }
}
