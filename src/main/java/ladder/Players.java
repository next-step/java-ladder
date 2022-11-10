package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> input) {
        this.players = input.stream().map(Player::new).collect(Collectors.toUnmodifiableList());
    }

    public List<Player> getPlayers() {
        return players;
    }
}
