package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    public Players(final String[] players) {
        this(Stream.of(players)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    private Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
