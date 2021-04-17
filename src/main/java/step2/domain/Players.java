package step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {
    public static final String SPLIT_COMMA = ",";

    public List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String players) {
        return Arrays.stream(players.split(SPLIT_COMMA))
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
