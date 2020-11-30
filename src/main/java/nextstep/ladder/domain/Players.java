package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    public static final String NAME_SPLITTER = ",";
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players from(String names) {
        return new Players(Arrays.stream(names.split(NAME_SPLITTER))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getSize() {
        return players.size();
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
