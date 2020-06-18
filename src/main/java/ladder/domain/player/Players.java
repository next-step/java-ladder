package ladder.domain.player;

import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<Player> players) {
        validate(players);
        return new Players(players);
    }

    private static void validate(List<Player> players) {
        validateSize(players);
        validateDuplication(players);
    }

    private static void validateSize(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("참여하는 사람의 수는 1명 이상이어야 합니다.");
        }
    }

    private static void validateDuplication(List<Player> players) {
        long distinctCount = players.stream()
                .distinct()
                .count();

        if (distinctCount != players.size()) {
            throw new IllegalArgumentException("참여하는 사람의 이름은 중복되지 않아야 합니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> getContent() {
        return Collections.unmodifiableList(players);
    }

    public int findIndexByName(String name) {
        Player player = players.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 사람이 없습니다."));

        return players.indexOf(player);
    }
}
