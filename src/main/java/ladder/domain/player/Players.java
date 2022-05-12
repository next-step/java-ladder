package ladder.domain.player;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("players는 빈 값일 수 없습니다.");
        }
    }

    public static Players from(List<String> playerNames) {
        return new Players(
                playerNames.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
