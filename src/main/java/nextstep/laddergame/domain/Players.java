package nextstep.laddergame.domain;

import java.util.List;

public class Players {

    private static final String INVALID_PLAYER_SIZE_EXCEPTION_MESSAGE = "참여자는 한 명 이상이어야 합니다.";
    private static final String DUPLICATE_NAME_EXCEPTION_MESSAGE_FORMAT = "중복된 이름이 존재합니다. playerNames: %s";
    public static final int MINIMUM_COUNT_OF_PLAYER = 2;

    private final List<PlayerName> playerNames;

    private Players(List<PlayerName> playerNames) {
        validatePlayerSize(playerNames);
        validateNonDuplicatedNames(playerNames);
        this.playerNames = playerNames;
    }

    private void validatePlayerSize(List<PlayerName> playerNames) {
        if (playerNames == null || playerNames.size() < MINIMUM_COUNT_OF_PLAYER) {
            throw new IllegalArgumentException(INVALID_PLAYER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateNonDuplicatedNames(List<PlayerName> playerNames) {
        if (playerNames.size() != countUniqueNames(playerNames)) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_EXCEPTION_MESSAGE_FORMAT, playerNames));
        }
    }

    private long countUniqueNames(List<PlayerName> playerNames) {
        return playerNames.stream()
                .distinct()
                .count();
    }

    public static Players of(List<PlayerName> playerNames) {
        return new Players(playerNames);
    }

    public boolean contains(PlayerName playerName) {
        return playerNames.contains(playerName);
    }
}
