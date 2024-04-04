package ladder.domain.player;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(final List<Player> players) {
        validatePlayersAreNotEmpty(players);
        validatePlayersAreNotDuplicated(players);

        this.players = players;
    }

    private static void validatePlayersAreNotDuplicated(List<Player> players) {
        if (new HashSet<>(players).size() != players.size()) {
            throw new IllegalArgumentException("중복된 플레이어가 존재합니다. 플레이어: " + players);
        }
    }

    private static void validatePlayersAreNotEmpty(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("플레이어가 존재하지 않습니다.");
        }
    }

    public List<String> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Players from(final List<String> playerNames) {
        final List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());

        return new Players(players);
    }
}
