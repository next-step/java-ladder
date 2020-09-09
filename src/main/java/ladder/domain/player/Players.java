package ladder.domain.player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Players {
    private static final String DELIMITER = ",";

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<Player> players) {
        return new Players(players);
    }

    public static Players ofNames(String names) {
        return of(splitNames(names));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Player findPlayer(int position) {
        return players.get(position);
    }

    public int size() {
        return players.size();
    }

    private static List<Player> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(Player::of)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players that = (Players) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
