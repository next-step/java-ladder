package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players valueOf(List<String> stringPlayers) {
        return new Players(stringPlayers.stream()
                .map(stringPlayer -> new Player(stringPlayer))
                .collect(Collectors.toList()));
    }

    public int size() {
        return this.players.size();
    }

    public Player getPlayer(int index) {
        return this.players.get(index);
    }

    public List<Player> players() {
        return this.players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
