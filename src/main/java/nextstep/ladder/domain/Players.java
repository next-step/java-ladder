package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String[] playerNames) {
        this(Arrays.stream(playerNames)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        if (players != null && !players.isEmpty()) {
            this.players.addAll(players);
        }
    }
}
