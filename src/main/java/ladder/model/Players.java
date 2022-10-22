package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(String[] playersName) {
        this.players = Arrays.stream(playersName)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }
}
