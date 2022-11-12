package nextstep.ladder.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final Collection<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        return new Players(players);
    }

    public int getSize() {
        return this.players.size();
    }

    public List<Player> asList() {
        return Collections.unmodifiableList(this.players);
    }
}
