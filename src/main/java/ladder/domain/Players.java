package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String PLAYER_NAMES_DELIMITER = ",";
    private final List<Player> players;

    public Players(String names) {
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(String names) {
        String[] splitName = names.split(PLAYER_NAMES_DELIMITER);

        return Arrays.stream(splitName)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }
}
