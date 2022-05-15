package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> players) {
        return new Players(players.stream().map(Player::new).collect(Collectors.toList()));
    }
}
