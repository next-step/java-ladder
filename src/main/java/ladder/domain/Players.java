package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Players {

    public static final String DELIMITER = ",";
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Players(String names) {
        this(toPlayer(names));
    }

    public int size() {
        return players.size();
    }

    private static List<Player> toPlayer(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList())
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<PlayerName> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toUnmodifiableList());
    }

    public void each(Consumer<Player> consumer) {
        players.forEach(consumer);
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
