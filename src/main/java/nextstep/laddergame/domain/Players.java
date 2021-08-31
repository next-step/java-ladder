package nextstep.laddergame.domain;

import java.util.List;

public class Players {

    private static final String DUPLICATE_NAME_EXCEPTION_MESSAGE_FORMAT = "중복된 이름이 존재합니다. playerNames: %s";

    private final List<PlayerName> playerNames;
    private final PlayerCount playerCount;

    private Players(List<PlayerName> playerNames) {
        validateNonDuplicatedNames(playerNames);
        this.playerNames = playerNames;
        this.playerCount = PlayerCount.of(playerNames.size());
    }

    private void validateNonDuplicatedNames(List<PlayerName> playerNames) {
        if (playerNames == null || playerNames.size() != countUniqueNames(playerNames)) {
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
