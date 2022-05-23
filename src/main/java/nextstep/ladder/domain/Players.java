package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public static Players of(List<String> playersAsString) {
        return new Players(playersAsString.stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    public int countOfLines() {
        return players.size() - 1;
    }

    public List<Player> players() {
        return players;
    }
}
