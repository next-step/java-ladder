package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(String... player) {
        this(Arrays.stream(player).map(Player::new).collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        validNames(players);
        validSize(players);
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    private void validSize(List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validNames(List<Player> players) {
        int initSize = players.size();
        long distinctSize = players.stream()
            .distinct()
            .count();

        if (initSize != distinctSize) {
            throw new IllegalArgumentException("player name is not distinct");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Players))
            return false;
        Players that = (Players)o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String get(int index) {
        return players.get(index).getName();
    }
}
