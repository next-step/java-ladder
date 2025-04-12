package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<String> playerNames) {
        return new Players(playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerByPosition(int position) {
        return players.get(position);
    }

    public int count() {
        return players.size();
    }

}
