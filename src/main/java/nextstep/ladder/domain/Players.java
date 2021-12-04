package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        validatePlayersCount(players);
        this.players = players;
    }

    private void validatePlayersCount(List<Player> players) {
        if (Objects.isNull(players) || players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static Players from(String[] names) {
        List<Player> players = Arrays.stream(names)
                .map(Player::from)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public int playersCount() {
        return players.size();
    }

    public List<Player> playersName() {
        return players;
    }
}
