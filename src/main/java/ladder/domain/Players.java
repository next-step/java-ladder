package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<String> players) {
        this.players = players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static Players of(List<String> players) {
        return new Players(players);
    }

    public List<Player> allPlayers() {
        return players;
    }

    public int count() {
        return players.size();
    }

    public int index(Player player) {
        return players.indexOf(player);
    }

    public int index(String playerName) {
        return index(new Player(playerName));
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
