package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players of(final List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null");
        }

        PlayerCount.validate(names.size());

        return new Players(names.stream()
                .map(Name::of)
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    public PlayerCount count() {
        return PlayerCount.of(players.size());
    }

    public Stream<Player> stream() {
        return players.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players other = (Players) o;
        return Objects.equals(players, other.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    public List<Player> collect() {
        return players;
    }

    public Player get(int index) {
        return players.get(index);
    }
}
