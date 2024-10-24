package ladder2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(String... players) {
        this(Arrays.stream(players).map(Player::new).collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException();
        }
        this.players = players;
    }

    public int size() {
        return players.size();
    }
}
