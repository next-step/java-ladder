package nextstep.ladder.domain;

import nextstep.ladder.exception.NotFoundPlayerException;

import java.util.Arrays;
import java.util.Collections;
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

    public Player playerOfIndex(int index) {
        return players.get(index);
    }

    public int playersCount() {
        return players.size();
    }

    public Player findPlayer(Player findPlayer) {
        return players.stream()
                .filter(player -> player.equals(findPlayer))
                .findFirst()
                .orElseThrow(NotFoundPlayerException::new);
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players);
    }
}
