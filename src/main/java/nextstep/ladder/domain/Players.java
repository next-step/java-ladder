package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players fromString(List<String> playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return new Players(playerNames.stream().map(Player::new).collect(Collectors.toList()));
    }


    public List<String> toStringList() {
        return players.stream().map(Player::toString).collect(Collectors.toList());
    }
}
