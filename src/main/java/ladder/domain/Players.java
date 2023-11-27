package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;
    private final long nameLengthMax;

    private Players(List<Player> players) {
        this.players = players;
        this.nameLengthMax = lengthMax(players);
    }

    public static Players of(String... names) {
        return of(Arrays.asList(names));
    }

    public static Players of(List<String> names) {
        return new Players(namesToPlayers(names));
    }

    private static List<Player> namesToPlayers(List<String> names) {
        return names.stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    private long lengthMax(List<Player> players) {
        return players.stream()
                .mapToLong(Player::length)
                .max()
                .orElseThrow();
    }

    public int size() {
        return players.size();
    }

    public List<Player> players() {
        return players;
    }

    public long lengthMax() {
        return nameLengthMax;
    }
}
