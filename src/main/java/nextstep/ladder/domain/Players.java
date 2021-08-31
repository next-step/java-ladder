package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<StringValue> players;

    public Players(final List<String> players) {
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(StringValue::new)
                        .collect(Collectors.toList())
        );
    }

    public boolean isSameSize(Results results) {
        return this.players.size() == results.sizeOfResults();
    }

    public String indexOf(int location) {
        return players.get(location).getValue();
    }

    public List<StringValue> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players player = (Players) o;
        return Objects.equals(players, player.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

}
