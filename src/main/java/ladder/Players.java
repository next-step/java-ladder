package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    public Players(String input) {
        List<String> playersOfString = Stream.of(input.split(",")).collect(Collectors.toList());
        this.players = playersOfString.stream().map(Player::new).collect(Collectors.toUnmodifiableList());
    }

    public List<Player> getPlayers() {
        return players;
    }
}
