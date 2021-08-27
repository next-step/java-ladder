package nextstep.laddergame.domain;

import java.util.List;

public class Players {

    private static final String INVALID_PLAYER_SIZE_EXCEPTION_MESSAGE = "참여자는 한 명 이상이어야 합니다.";

    private final List<PlayerName> playerNames;

    private Players(List<PlayerName> playerNames) {
        validatePlayerSize(playerNames);
        this.playerNames = playerNames;
    }

    private void validatePlayerSize(List<PlayerName> playerNames) {
        if (playerNames == null || playerNames.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PLAYER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public static Players of(List<PlayerName> playerNames) {
        return new Players(playerNames);
    }

    public boolean contains(PlayerName playerName) {
        return playerNames.contains(playerName);
    }
}
