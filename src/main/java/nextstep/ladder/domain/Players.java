package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String names) {
        this.players = Arrays.stream(names.split(","))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return players.size();
    }
}
