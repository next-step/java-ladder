package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String value) {
        List<Player> players = Optional.ofNullable(value)
                                .map(v -> toPlayers(splitComma(v)))
                                .orElseThrow(() -> new IllegalArgumentException());
        return new Players(players);
    }

    private static List<Player> toPlayers(String[] values) {
        return Arrays.stream(values)
                .map(Player::of)
                .collect(Collectors.toList());
    }

    private static String[] splitComma(String value) {
        return value.split(",");
    }

    public int getCountOfPlayer() {
        return this.players.size();
    };

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

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
