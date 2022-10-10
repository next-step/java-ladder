package ladder.domain;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> players() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Players)) return false;

        Players players1 = (Players) o;

        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return players != null ? players.hashCode() : 0;
    }

    public int count() {
        return players.size();
    }

    public Players move(Line line) {
        return new Players(players.stream()
                .map(player -> player.move(line))
                .collect(toList()));
    }
}
