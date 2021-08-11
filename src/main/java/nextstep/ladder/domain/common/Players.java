package nextstep.ladder.domain.common;

import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final List<Player> players) {
        return new Players(players);
    }

    public List<Player> getValues() {
        return Collections.unmodifiableList(players);
    }
}
