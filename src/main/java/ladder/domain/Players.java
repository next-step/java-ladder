package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private static final String SEPARATOR = ",";

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public Players (final String names) {
        this.players = Arrays.stream(names.split(SEPARATOR))
                             .map(Player::new)
                             .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }


    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}