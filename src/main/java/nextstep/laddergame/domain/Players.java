package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYER = 2;

    private final List<PlayerName> playerNames;

    private Players(List<PlayerName> playerNames) {
        validateMinimumPlayerCount(playerNames);
        validateNonDuplicatedNames(playerNames);
        this.playerNames = Collections.unmodifiableList(playerNames);
    }

    private void validateMinimumPlayerCount(List<PlayerName> playerNames) {
        if (playerNames == null || playerNames.size() < MINIMUM_COUNT_OF_PLAYER) {
            throw new IllegalArgumentException("참여자는 두 명 이상이어야 합니다.");
        }
    }

    private void validateNonDuplicatedNames(List<PlayerName> playerNames) {
        Set<PlayerName> distinctPlayerNames = new HashSet<>(playerNames);
        if (playerNames.size() != distinctPlayerNames.size()) {
            throw new IllegalArgumentException(String.format("중복된 이름이 존재합니다. playerNames: %s", playerNames));
        }
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

    public List<String> getPlayerNames() {
        return playerNames.stream()
                .map(PlayerName::toString)
                .collect(Collectors.toList());
    }

    public int size() {
        return playerNames.size();
    }

    public PlayerName playerNameAt(int position) {
        return playerNames.get(position);
    }
}
