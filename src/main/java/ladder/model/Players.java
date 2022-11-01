package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String[] playersName) {
        List<Player> players = Arrays.stream(playersName)
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }
}
