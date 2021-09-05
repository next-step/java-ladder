package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<PlayerName> playerNames;
    private final PlayerCount playerCount;

    private Players(List<PlayerName> playerNames) {
        validateNonDuplicatedNames(playerNames);
        this.playerNames = playerNames;
        this.playerCount = PlayerCount.of(playerNames.size());
    }

    private void validateNonDuplicatedNames(List<PlayerName> playerNames) {
        if (playerNames == null || playerNames.size() != countUniqueNames(playerNames)) {
            throw new IllegalArgumentException(String.format("중복된 이름이 존재합니다. playerNames: %s", playerNames));
        }
    }

    private long countUniqueNames(List<PlayerName> playerNames) {
        return playerNames.stream()
                .distinct()
                .count();
    }

    public static Players of(List<String> names) {
        return new Players(convertToPlayerNames(names));
    }

    private static List<PlayerName> convertToPlayerNames(List<String> names) {
        return names.stream()
                .map(PlayerName::of)
                .collect(Collectors.toList());
    }

    public boolean contains(String name) {
        return playerNames.contains(PlayerName.of(name));
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    public PlayerCount getPlayerCount() {
        return playerCount;
    }
}
