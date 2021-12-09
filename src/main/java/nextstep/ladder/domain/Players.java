package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_RAIL_COUNT = 2;

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players of(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null");
        }

        if (names.size() < MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + names.size());
        }

        return new Players(names.stream()
                .map(Name::of)
                .map(Player::of)
                .collect(Collectors.toList()));
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

    public int size() {
        return players.size();
    }
}
