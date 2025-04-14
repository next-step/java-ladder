package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException("플레이어가 존재하지 않습니다.");
        }
        this.players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
