package ladderGame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<String> players) {
        this.players = players.stream()
                .map(Player::of)
                .collect(Collectors.toList());
    }

    public static Players of(List<String> players) {
        return new Players(players);
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
