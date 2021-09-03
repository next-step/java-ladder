package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Name> players;

    public Players(final List<String> players) {
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Name::new)
                        .collect(Collectors.toList())
        );
    }

    public boolean isSameSize(Results results) {
        return this.players.size() == results.size();
    }

    public String indexOf(int location) {
        return players.get(location).getValue();
    }

    public List<Name> getPlayers() {
        return players;
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
