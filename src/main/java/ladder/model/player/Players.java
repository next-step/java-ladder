package ladder.model.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String DELIMITER_COMMA = ",";

    private final List<Player> players;

    public Players(String input) {
        this.players = Arrays.stream(input.split(DELIMITER_COMMA))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
