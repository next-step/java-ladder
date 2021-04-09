package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String SEPARATOR = ",";

    private final List<Player> players;

    public Players(String names) {
        players = Arrays.stream(names.split(SEPARATOR))
            .map(Player::new)
            .collect(Collectors.toList());
    }

    public int playerCount() {
        return players.size();
    }



}
