package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Players {
    private final List<Player> players;

    public static Players of(final String playerNames, final String separator) {
        return Stream.of(playerNames.split(separator))
                .map(Player::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
    }

    public Players(final List<Player> players) {
        this.players = new ArrayList<>(Collections.unmodifiableList(players));
    }

    public int size() {
        return players.size();
    }

    public Player getPlayer(final Location playerLocation) {
        return players.get(playerLocation.toInt());
    }
}
