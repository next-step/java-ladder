package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String NAME_SEPARATOR = ",";
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String testPlayers) {
        return new Players(Arrays.stream(testPlayers.trim().split(NAME_SEPARATOR))
                .map(String::trim)
                .map(Player::from)
                .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
