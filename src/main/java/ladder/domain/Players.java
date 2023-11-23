package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;
    private final long nameLengthMax;

    private Players(List<Player> players) {
        this.players = players;
        this.nameLengthMax = nameLengthMax(players);
    }

    public static Players of(List<String> names) {
        return new Players(namesToPlayers(names));
    }

    private static List<Player> namesToPlayers(List<String> names) {
        return names.stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    private long nameLengthMax(List<Player> players) {
        return players.stream()
                .mapToLong(player -> player.nameLength())
                .max().getAsLong();
    }

    public List<Player> players() {
        return players;
    }

    public long nameLengthMax() {
        return nameLengthMax;
    }
}
