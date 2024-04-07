package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }
    }

    public static Players of(List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public int count() {
        return players.size();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }
}
