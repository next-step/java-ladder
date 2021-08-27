package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(String[] playerNames) {
        this.players = Arrays.stream(playerNames)
            .map(Player::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public static Players from(String[] playerNames) {
        return new Players(playerNames);
    }

    public int count() {
        return players.size();
    }
}
