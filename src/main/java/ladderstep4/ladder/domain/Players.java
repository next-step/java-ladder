package ladderstep4.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String DELIMITER = ",";

    private final List<Player> values;

    public Players(String names) {
        this(Arrays.stream(names.split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        this.values = players;
    }

    public Player findPlayer(Position position) {
        return values.get(position.value());
    }
}
