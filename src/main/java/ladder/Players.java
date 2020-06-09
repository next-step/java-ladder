package ladder;

import java.util.Collections;
import java.util.List;

public class Players {

    private final List<PlayerName> playerNames;

    private Players(List<PlayerName> playerNames) {
        this.playerNames = playerNames;
    }

    public static Players of(List<PlayerName> playerNames) {
        validate(playerNames);
        return new Players(playerNames);
    }

    private static void validate(List<PlayerName> playerNames) {
        validateSize(playerNames);
        validateDuplication(playerNames);
    }

    private static void validateSize(List<PlayerName> playerNames) {
        if (playerNames == null || playerNames.isEmpty()) {
            throw new IllegalArgumentException("참여하는 사람의 수는 1명 이상이어야 합니다.");
        }
    }

    private static void validateDuplication(List<PlayerName> playerNames) {
        long distinctCount = playerNames.stream()
                .distinct()
                .count();

        if (distinctCount != playerNames.size()) {
            throw new IllegalArgumentException("참여하는 사람의 이름은 중복되지 않아야 합니다.");
        }
    }

    public int size() {
        return playerNames.size();
    }

    public List<PlayerName> getContent() {
        return Collections.unmodifiableList(playerNames);
    }
}
