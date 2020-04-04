package ladder.domain;

import ladder.exception.PlayerException;

import java.util.List;

public class Players {

    private static final String PLAYER_COUNT_ERR_MSG = "2명 이상 참가 가능 합니다.";
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validatePlayerCount(players);
        this.players = players;
    }

    private void validatePlayerCount(final List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new PlayerException(PLAYER_COUNT_ERR_MSG);
        }
    }
}
