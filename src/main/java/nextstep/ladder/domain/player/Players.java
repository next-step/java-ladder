package nextstep.ladder.domain.player;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> names) {
        return new Players(names.stream()
                                .map(Player::from)
                                .collect(Collectors.toUnmodifiableList()));
    }

    public List<String> getNames() {
        return players.stream()
                      .map(Player::getName)
                      .collect(Collectors.toUnmodifiableList());
    }
}
