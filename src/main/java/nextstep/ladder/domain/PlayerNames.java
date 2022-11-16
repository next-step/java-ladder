package nextstep.ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class PlayerNames {
    public static final int MIN_SIZE = 2;

    private final List<PlayerName> playerNames;

    public PlayerNames(final List<PlayerName> playerNames) {
        validatePlayerNames(playerNames);
        this.playerNames = playerNames;
    }

    private static void validatePlayerNames(final List<PlayerName> playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException("Player Names can not be null");
        }
        if (playerNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException(
                String.format("Player Names size should be greater than %s", MIN_SIZE));
        }
        if (getUniqueNameCount(playerNames) != playerNames.size()) {
            throw new IllegalArgumentException("All names should be unique");
        }
    }

    private static int getUniqueNameCount(final List<PlayerName> playerNames) {
        return new HashSet<>(playerNames).size();
    }

    public int size() {
        return playerNames.size();
    }

    public List<String> getNames() {
        return playerNames.stream()
            .map(PlayerName::getValue)
            .collect(Collectors.toUnmodifiableList());
    }
}
